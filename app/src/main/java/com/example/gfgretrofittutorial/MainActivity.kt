package com.example.gfgretrofittutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.example.gfgretrofittutorial.databinding.ActivityMainBinding
import com.example.gfgretrofittutorial.model.EntryList
import com.example.gfgretrofittutorial.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<MainActivityViewModel>()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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