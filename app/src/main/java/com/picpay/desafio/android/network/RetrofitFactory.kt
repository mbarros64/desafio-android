package com.picpay.desafio.android.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitFactory {
    private const val API_KEY = "https://609a908e0f5a13001721b74e.mockapi.io/picpay/api/"
    fun <T> build(apiClass: Class<T>): T {
        return Retrofit.Builder()
            .baseUrl(API_KEY)
            .client(OkHttpClient.Builder().build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(apiClass)
    }
}