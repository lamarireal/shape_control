package com.shackleton.shape.db.laravel.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Module(
    @SerializedName("id")           var id: Int,
    @SerializedName("title")        var title: String,
    @SerializedName("description")  var description: String,
    @SerializedName("button_text")       var button_text: String,
    @SerializedName("url")          var url: String
) : Parcelable