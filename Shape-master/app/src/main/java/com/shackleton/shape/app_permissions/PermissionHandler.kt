package com.shackleton.shape.app_permissions

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
// H0laaa 
class PermissionHandler(private val context: Context) {

    private val multiplePermissionId = 14
    private val multiplePermissionNameList = if (Build.VERSION.SDK_INT >= 33) {
        arrayListOf(
            android.Manifest.permission.READ_MEDIA_AUDIO,
            android.Manifest.permission.READ_MEDIA_VIDEO,
            android.Manifest.permission.READ_MEDIA_IMAGES,
        )
    } else {
        arrayListOf(
            android.Manifest.permission.READ_EXTERNAL_STORAGE,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
        )
    }

    fun checkAndRequestMultiplePermissions(callback: () -> Unit) {
        val listPermissionNeeded = arrayListOf<String>()
        for (permission in multiplePermissionNameList) {
            if (ContextCompat.checkSelfPermission(
                    context,
                    permission
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                listPermissionNeeded.add(permission)
            }
        }
        if (listPermissionNeeded.isNotEmpty()) {
            ActivityCompat.requestPermissions(
                context as AppCompatActivity,
                listPermissionNeeded.toTypedArray(),
                multiplePermissionId
            )
        } else {
            callback()
        }
    }

    fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray,
        onPermissionDenied: () -> Unit,
        onPermissionGranted: () -> Unit,
        onPermissionPermanentlyDenied: () -> Unit,
    ) {
        if (requestCode == multiplePermissionId) {
            if (grantResults.isNotEmpty()) {
                var isGrant = true
                for (element in grantResults) {
                    if (element == PackageManager.PERMISSION_DENIED) {
                        isGrant = false
                        break
                    }
                }
                if (isGrant) {
                    onPermissionGranted()
                } else {
                    var someDenied = false
                    for (permission in permissions) {
                        if (!ActivityCompat.shouldShowRequestPermissionRationale(
                                context as AppCompatActivity,
                                permission
                            )
                        ) {
                            if (ActivityCompat.checkSelfPermission(
                                    context,
                                    permission
                                ) == PackageManager.PERMISSION_DENIED
                            ) {
                                someDenied = true
                                break
                            }
                        }
                    }
                    if (someDenied) {
                        onPermissionPermanentlyDenied()
                    } else {
                        showWarningPermissionDialog { _, _ ->
                            checkAndRequestMultiplePermissions{

                            }
                        }
                    }
                }
            }
        }
    }

    private fun showWarningPermissionDialog(onRetry: DialogInterface.OnClickListener) {
        AlertDialog.Builder(context)
            .setMessage("You need to grant all permissions to continue.")
            .setPositiveButton("Retry", onRetry)
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            .setCancelable(false)
            .show()
    }

    fun openAppSettings() {
        val intent = Intent().apply {
            action = android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS
            data = Uri.fromParts("package", context.packageName, null)
        }
        context.startActivity(intent)
    }
}
