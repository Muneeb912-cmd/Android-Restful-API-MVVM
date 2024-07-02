package com.example.week_3_challenge_3_1.view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.week_3_challenge_3_1.model.NewsData
import com.example.week_3_challenge_3_1.model.NewsDataRepository
import kotlinx.coroutines.Dispatchers

import com.example.week_3_challenge_3_1.network.RetroInstance
import kotlinx.coroutines.launch

class NewsViewModel(private val repository: NewsDataRepository):ViewModel() {

    private val newsData = repository.getNews()

    fun getNewsListObserver(): LiveData<NewsData> {
        return newsData
    }

    fun apiCall() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.fetchNewsDataFromAPI()
        }
    }
}