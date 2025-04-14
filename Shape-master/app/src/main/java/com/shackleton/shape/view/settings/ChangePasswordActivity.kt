package com.shackleton.shape.view.settings


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.shackleton.shape.databinding.ActivityChangePasswordBinding
import com.shackleton.shape.db.laravel.request.getAuthHeader
import com.shackleton.shape.db.laravel.request.openConnection
import com.shackleton.shape.db.laravel.request.response.GeneralResponse
import com.shackleton.shape.db.laravel.request.service.PassAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChangePasswordActivity : AppCompatActivity() {

    private lateinit var binding : ActivityChangePasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChangePasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.changePassword.setOnClickListener {
            openConnection().create(PassAPI::class.java).changepassword(getAuthHeader(),binding.currentPassword.text.toString(),binding.newPassword.text.toString(),binding.confirmPassword.text.toString())
                .enqueue(object : Callback<GeneralResponse>{
                    override fun onResponse(
                        call: Call<GeneralResponse>,
                        response: Response<GeneralResponse>
                    ) {
                        if(response.isSuccessful){
                            Toast.makeText(applicationContext, response.body()?.message, Toast.LENGTH_SHORT).show()
                            finish()
                        }
                    }

                    override fun onFailure(call: Call<GeneralResponse>, t: Throwable) {
                        Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
                    }
                })
        }


        binding.btnatras1.setOnClickListener {
            finish()
        }

    }
}


