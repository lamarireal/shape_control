package com.shackleton.shape.db.laravel.request.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.shackleton.shape.db.laravel.model.User
import kotlinx.parcelize.Parcelize

@Parcelize
class GeneralResponse2<T : Parcelable>(
    @SerializedName("success")  var success: Boolean,
    @SerializedName("user")  var user: User,
    @SerializedName("access_token")     var access_token: String,
    @SerializedName("data")     var data: T,
) : Parcelable