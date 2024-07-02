package com.example.week_3_challenge_3_1.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.week_3_challenge_3_1.network.RetroInstance
import com.example.week_3_challenge_3_1.network.RetroService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsDataRepository {

    private val newsDataFromAPI = MutableLiveData<NewsData>()

    fun getNews(): LiveData<NewsData> {
        return newsDataFromAPI
    }

    suspend fun fetchNewsDataFromAPI(): LiveData<NewsData> {
        return withContext(Dispatchers.IO) {
            try {

                val response = RetroInstance.retrofitInstance.getDataFromAPI()
                newsDataFromAPI.postValue(response)
            } catch (e: Exception) {
                Log.d("API Call", "apiCall: ${e.message}")
            }
            getNews()
        }

    }
}
