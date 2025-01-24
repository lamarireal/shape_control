package com.shackleton.shape.db.laravel.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class User(
    @SerializedName("id")           var id: Int,
    @SerializedName("full_name")         var full_name: String,
    @SerializedName("nick")    var nick: String,
    @SerializedName("email")        var email: String,
    @SerializedName("user_image_url")        var user_image_url: String,
    @SerializedName("followers_count")        var followers_count: Int,
) : Parcelable