package com.example.gfgretrofittutorial.API

import com.example.gfgretrofittutorial.model.EntryList
import retrofit2.Response
import retrofit2.http.GET

interface EntryAPI {
    @GET("/entries")
    suspend fun getQuotes() : Response<EntryList>
}
