package com.shackleton.shape.db.laravel.model
//Toda esta clase, la he creado yo.
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
class LienzoValidacion(

    /*Asumo que estas variables corresponden en realidad a un statement, dado que éste en concreto
    *solo tiene un statement, experimento, pues solo podremos generar uno.
    */

    @SerializedName("a") var a: String?,
    @SerializedName("b") var b: String?,
    @SerializedName("c") var c: String?,
    @SerializedName("d") var d: String?,
    @SerializedName("e") var e: String?,
    @SerializedName("f") var f: String?,
    @SerializedName("g") var g: String?,
    @SerializedName("h") var h: String?,
    @SerializedName("i") var i: String?,
    @SerializedName("j") var j: String?,
    @SerializedName("k") var k: String?,
    @SerializedName("l") var l: String?,
    @SerializedName("m") var m: String?,
    @SerializedName("n") var n: String?,
    @SerializedName("o") var o: String?,
    @SerializedName("p") var p: String?,
    @SerializedName("q") var q: String?,
    @SerializedName("r") var r: String?,
    @SerializedName("s") var s: String?,
    @SerializedName("t") var t: String?,
    @SerializedName("u") var u: String?,
    @SerializedName("v") var v: String?,
    @SerializedName("w") var w: String?,
    @SerializedName("x") var x: String?,
    @SerializedName("y") var y: String?,
    @SerializedName("z") var z: String?,
    @SerializedName("aa") var aa: String?,
    @SerializedName("ab") var ab: String?,
    @SerializedName("ac") var ac: String?,
    @SerializedName("ad") var ad: String?



) : Parcelable