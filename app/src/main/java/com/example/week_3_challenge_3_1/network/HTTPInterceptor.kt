package com.example.week_3_challenge_3_1.network

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class HTTPInterceptor:Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)
        if (!response.isSuccessful) {
            when (response.code) {
                401 -> {
                    // Unauthorized
                    throw IOException("Unauthorized request")
                }
                404 -> {
                    // Not found
                    throw IOException("Resource not found")
                }
                // Handle other codes as needed
                else -> {
                    throw IOException("Unexpected error: ${response.code}")
                }
            }
        }

        return response
    }
}