package com.shackleton.shape.db.laravel.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
class LienzoPropuesta (
    @SerializedName("a")        var a: String?,
    @SerializedName("b")        var b: String?,
    @SerializedName("c")        var c: String?,
    @SerializedName("d")        var d: String?,
    @SerializedName("e")        var e: String?,
    @SerializedName("f")        var f: String?,

    ) : Parcelable