package com.example.week_3_challenge_3_1.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance {

    companion object {
        private const val URL = "https://newsapi.org/v2/"

        private val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(HTTPInterceptor())
            .build()

        fun getRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()

        }

        val retrofitInstance = getRetrofitInstance().create(RetroService::class.java)
    }

}