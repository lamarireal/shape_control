package com.shackleton.shape.db.laravel.request.modelRequest

import retrofit2.http.Field


class Modelos {
    data class PDFRequest1(
        @Field("project_id") val project_id: Int,
        @Field("a") val a: String?,
        @Field("b") val b: String?,
        @Field("c") val c: String?,
        @Field("d") val d: String?,
        @Field("e") val e: String?,
        @Field("f") val f: String?,
        @Field("g") val g: String?,
        @Field("h") val h: String?,
        @Field("j") val j: String?,
        @Field("i") val i: String?,
        @Field("k") val k: String?,
        @Field("l") val l: String?,
        @Field("m") val m: String?,
        @Field("n") val n: String?

    )

}

