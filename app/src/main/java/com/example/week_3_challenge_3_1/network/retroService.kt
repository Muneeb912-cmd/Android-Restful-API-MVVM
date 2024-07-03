package com.example.week_3_challenge_3_1.network

import com.example.week_3_challenge_3_1.model.NewsData
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {

    @GET("everything")
    suspend fun getDataFromAPI(
        @Query("q") query: String="tesla",
        @Query("from") from: String = "2024-06-03",
        @Query("sortBy") sortBy: String = "publishedAt",
        @Query("apiKey") apiKey: String = "90aba61021f44215937abcae831d2128"
    ): NewsData

    @GET("everything")
    suspend fun getNewsByTitle(
        @Query("q") query: String,
        @Query("from") from: String = "2024-06-03",
        @Query("sortBy") sortBy: String = "publishedAt",
        @Query("apiKey") apiKey: String = "90aba61021f44215937abcae831d2128"
    ): NewsData

}