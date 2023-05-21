package com.example.marveltest.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.marveltest.R
import com.example.marveltest.databinding.ActivityMainBinding
import com.example.marveltest.ui.adapter.SeriesAdapter
import com.example.marveltest.ui.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        val adapter = SeriesAdapter(mutableListOf(), viewModel)
        binding.recyclerView.adapter = adapter

    }
}