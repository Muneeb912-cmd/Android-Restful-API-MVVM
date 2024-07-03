package com.example.week_3_challenge_3_1.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.week_3_challenge_3_1.network.RetroInstance
import com.example.week_3_challenge_3_1.network.RetroService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NewsDataRepository {

    private val newsDataFromAPI = MutableLiveData<NewsData>()
    private val newsDataByTitle = MutableLiveData<NewsData>()

    fun getNews(): LiveData<NewsData> {
        return newsDataFromAPI
    }

    fun getNewsByTitleLiveData(): LiveData<NewsData> {
        return newsDataByTitle
    }

    suspend fun fetchNewsDataFromAPI(): LiveData<NewsData> {
        return withContext(Dispatchers.IO) {
            try {
                val response = RetroInstance.getRetrofitInstance().create(RetroService::class.java).getDataFromAPI()
                newsDataFromAPI.postValue(response)
            } catch (e: Exception) {
                Log.d("API Call", "apiCall: ${e.message}")
            }
            getNews()
        }
    }

    suspend fun fetchNewsByTitle(title: String): LiveData<NewsData> {
        return withContext(Dispatchers.IO) {
            try {
                val response = RetroInstance.getRetrofitInstance().create(RetroService::class.java).getNewsByTitle(title)
                newsDataByTitle.postValue(response)
            } catch (e: Exception) {
                Log.d("API Call", "apiCall: ${e.message}")
            }
            getNewsByTitleLiveData()
        }
    }
}
