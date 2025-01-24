package com.shackleton.shape.db.laravel.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
class Proyecto(
    @SerializedName("id")        var id: String,
    @SerializedName("name")  var name: String,
    @SerializedName("description")  var description: String,
    @SerializedName("user_id")       var user_id: String,
    @SerializedName("created_at")          var created_at: String,
    @SerializedName("updated_at") var updated_at : String,
) : Parcelable