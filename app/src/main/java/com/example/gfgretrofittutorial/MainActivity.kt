package com.example.gfgretrofittutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.gfgretrofittutorial.API.EntryAPI
import com.example.gfgretrofittutorial.API.RetrofitHelper
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val quotesApi = RetrofitHelper.getInstance().create(EntryAPI::class.java)
        // launching a new coroutine
        GlobalScope.launch {
            var i = 1
            val result = quotesApi.getQuotes()
            result.body()?.entries?.forEach {
                Log.d("MainActivity $i", it.toString())
                i++
            }
        }
    }
}