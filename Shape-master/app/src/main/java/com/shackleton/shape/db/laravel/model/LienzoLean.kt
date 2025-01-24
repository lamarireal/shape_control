package com.shackleton.shape.db.laravel.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
class LienzoLean(
    @SerializedName("a")        var a: String?,
    @SerializedName("b")        var b: String?,
    @SerializedName("c")        var c: String?,
    @SerializedName("d")        var d: String?,
    @SerializedName("e")        var e: String?,
    @SerializedName("f")        var f: String?,
    @SerializedName("g")        var g: String?,
    @SerializedName("h")        var h: String?,
    @SerializedName("i")        var i: String?,

) : Parcelable