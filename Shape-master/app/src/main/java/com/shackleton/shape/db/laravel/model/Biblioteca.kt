package com.shackleton.shape.db.laravel.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
class Biblioteca (
    @SerializedName("title")        var title: String,
    @SerializedName("description")  var description: String,
    @SerializedName("url")          var url: String,
    @SerializedName("resumen")          var resumen: String
) : Parcelable