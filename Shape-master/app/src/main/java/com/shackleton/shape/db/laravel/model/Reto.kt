package com.shackleton.shape.db.laravel.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
class Reto(
    @SerializedName("title")        var title: String,
    @SerializedName("category")  var category: String,
    @SerializedName("url")  var url: String,
    @SerializedName("duration")       var duration: String,
    @SerializedName("goal")          var goal: String,
    @SerializedName("benefit1") var benefit1 : String,
    @SerializedName("benefit2") var benefit2 : String,
    @SerializedName("benefit3") var benefit3 : String,
    @SerializedName("benefit4") var benefit4 : String,
) : Parcelable