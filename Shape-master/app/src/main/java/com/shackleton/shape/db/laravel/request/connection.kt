package com.shackleton.shape.db.laravel.request

import com.shackleton.shape.shared.SharedApp
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun openConnection(): Retrofit {
    return Retrofit.Builder()
        .baseUrl("http://10.0.2.2:8000/") // Elegí la opción con "/"
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun openConnectionWithAuth(): Retrofit {
    val interceptor = Interceptor { chain ->
        val request: Request = chain.request().newBuilder()
            .addHeader("Authorization", getAuthHeader())
            .build()
        chain.proceed(request)
    }

    val httpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    return Retrofit.Builder()
        .baseUrl("http://10.0.2.2:8000/") // Consistencia en ambos métodos
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient)
        .build()
}

fun getAuthHeader(): String {
    return "Bearer " + SharedApp.preferences.session
}
