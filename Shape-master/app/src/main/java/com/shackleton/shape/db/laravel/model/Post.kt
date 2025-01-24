package com.shackleton.shape.db.laravel.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
class Post (
    @SerializedName("id")        var id: Int,
    @SerializedName("name")        var name: String,
    @SerializedName("descripcion")  var descripcion: String,
    @SerializedName("image_url")  var image_url: String?,
    @SerializedName("user_image_url")  var user_image_url: String,
    @SerializedName("user_id")  var user_id: Int,
    @SerializedName("nick")  var nick: String,
    @SerializedName("question_id")       var question_id: Int,
    @SerializedName("created_at")          var created_at: String,
    @SerializedName("updated_at") var updated_at : String,
    private var expandable : Boolean


) : Parcelable{
    fun isExpandable(): Boolean {
        return expandable
    }

    fun setExpandable(expandable: Boolean) {
        this.expandable = expandable
    }
}