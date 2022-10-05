package com.example.gfgretrofittutorial.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gfgretrofittutorial.API.EntryAPI
import com.example.gfgretrofittutorial.API.RestAPIService
import com.example.gfgretrofittutorial.API.RetrofitHelper
import com.example.gfgretrofittutorial.model.EntryList
import kotlinx.coroutines.launch

class MainActivityViewModel: ViewModel() {

    val api = RestAPIService().quotesApi
    private val _apiCaller = MutableLiveData<EntryList>()
    val apiCaller: LiveData<EntryList>
        get() = _apiCaller

    fun getEntries(){
        viewModelScope.launch{
            val result = api.getQuotes()
            _apiCaller.postValue(result.body())
        }
    }
}