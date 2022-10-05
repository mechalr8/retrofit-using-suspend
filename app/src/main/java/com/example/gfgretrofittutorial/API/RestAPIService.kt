package com.example.gfgretrofittutorial.API

class RestAPIService {
    val quotesApi = RetrofitHelper.getInstance().create(EntryAPI::class.java)
}