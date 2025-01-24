package com.shackleton.shape.db.laravel.request.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
class GeneralListResponse <T : Parcelable>(
    @SerializedName("success")  var success: Boolean,
    @SerializedName("data")     var data:List<T>?,
    @SerializedName("message")  var message: String,
) : Parcelable