package com.shackleton.shape.db.laravel.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
class LienzoModelo(
    @SerializedName("a")        var a: String?,
    @SerializedName("b")        var b: String?,
    @SerializedName("c")        var c: String?,
    @SerializedName("d")        var d: String?,
    @SerializedName("e")        var e: String?,
    @SerializedName("f")        var f: String?,
    @SerializedName("g")        var g: String?,
    @SerializedName("h")        var h: String?,
    @SerializedName("i")        var i: String?,
    @SerializedName("j")        var j: String?,
    @SerializedName("k")        var k: String?,
    @SerializedName("l")        var l: String?,
    @SerializedName("m")        var m: String?,
    @SerializedName("n")        var n: String?,

    ) : Parcelable