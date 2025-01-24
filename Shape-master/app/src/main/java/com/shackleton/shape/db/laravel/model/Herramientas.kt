package com.shackleton.shape.db.laravel.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
class Herramientas (
    @SerializedName("title")        var title: String,
    @SerializedName("description")  var description: String,
    @SerializedName("button")       var button: String,
    @SerializedName("url")          var url: String
) : Parcelable