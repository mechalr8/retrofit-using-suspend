package com.example.gfgretrofittutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.example.gfgretrofittutorial.model.EntryList
import com.example.gfgretrofittutorial.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<MainActivityViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getEntries()
        viewModel.apiCaller.observe(
            this

        ) { entry ->
            if (entry is EntryList) {
                entry.entries.forEach {
                    Log.d("Data:", it.toString())
                }
            }
        }
    }
}