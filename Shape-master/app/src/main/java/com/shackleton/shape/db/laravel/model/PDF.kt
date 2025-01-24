package com.shackleton.shape.db.laravel.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
class PDF (
    @SerializedName("project_id") val projectId: Int,
    @SerializedName("pdf") val pdf: Int,
    @SerializedName("respuestas") val respuestas: Array<String>
) : Parcelable