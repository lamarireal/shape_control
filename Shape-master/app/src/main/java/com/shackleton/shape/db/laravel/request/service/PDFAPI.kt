package com.shackleton.shape.db.laravel.request.service

import com.shackleton.shape.db.laravel.model.LienzoLean
import com.shackleton.shape.db.laravel.model.LienzoModelo
import com.shackleton.shape.db.laravel.model.LienzoPropuesta
import com.shackleton.shape.db.laravel.model.LienzoValidacion
import com.shackleton.shape.db.laravel.model.LienzoVision
import com.shackleton.shape.db.laravel.request.modelRequest.Modelos
import com.shackleton.shape.db.laravel.request.response.GeneralResponse
import com.shackleton.shape.db.laravel.request.response.GeneralResponse2
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

interface PDFAPI {
    @POST("api/fill-data-pdf1")
    fun editPDFLienzoVision(@Header("Authorization") token: String, @Body request : Modelos.PDFRequest1 ) : Call<GeneralResponse>
    @POST("api/fill-data-pdf2")
    fun editPDFLienzoLeanProject(@Header("Authorization") token: String,@Body request : Modelos.PDFRequest1  ) : Call<GeneralResponse>
    @POST("api/fill-data-pdf3")
    fun editPDFLienzoValidacion(@Header("Authorization") token: String, @Body request : Modelos.PDFRequest1  ) : Call<GeneralResponse>
    @POST("api/fill-data-pdf4")
    fun editPDFLienzoPropuestas(@Header("Authorization") token: String, @Body request : Modelos.PDFRequest1  ) : Call<GeneralResponse>
    @POST("api/fill-data-pdf5")
    fun editPDFLienzoModelo(@Header("Authorization") token: String,  @Body request : Modelos.PDFRequest1  ) : Call<GeneralResponse>

    @FormUrlEncoded
    @POST("api/getDataFromLienzoLean")
    fun getDataFromLienzoLean(@Header("Authorization") token: String,  @Field("project_name") project_name : String  ) : Call<GeneralResponse2<LienzoLean>>
    @FormUrlEncoded
    @POST("api/getDataFromLienzoPropuesta")
    fun getDataFromLienzoPropuesta(@Header("Authorization") token: String,  @Field("project_name") project_name : String  ) : Call<GeneralResponse2<LienzoPropuesta>>
    @FormUrlEncoded
    @POST("api/getDataFromLienzoVision")
    fun getDataFromLienzoVision(@Header("Authorization") token: String,  @Field("project_name") project_name : String ) : Call<GeneralResponse2<LienzoVision>>
    @FormUrlEncoded
    @POST("api/getDataFromLienzoModelo")
    fun getDataFromLienzoModelo(@Header("Authorization") token: String, @Field("project_name") project_name : String ) : Call<GeneralResponse2<LienzoModelo>>

    //Nota Pedro: Aquí esta el que nos quedaba.Esto antes estaba comentado.

    @FormUrlEncoded
   @POST("api/getDataFromLienzoValidacion")
    fun getDataFromLienzoValidacion(@Header("Authorization") token: String,  @Field("project_name") project_name : String  )
    : Call<GeneralResponse2<LienzoValidacion>>

}