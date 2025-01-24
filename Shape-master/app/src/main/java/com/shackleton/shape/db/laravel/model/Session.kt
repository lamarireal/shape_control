package com.shackleton.shape.db.laravel.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
class Session(
    @SerializedName("token")    var token: String,
    @SerializedName("name")     var name: String,
) : Parcelable