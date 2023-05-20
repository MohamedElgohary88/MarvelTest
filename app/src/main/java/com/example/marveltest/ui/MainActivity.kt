package com.example.marveltest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.marveltest.R
import com.example.marveltest.data.local.SeriesDatabase
import com.example.marveltest.data.remote.api.Api
import com.example.marveltest.data.remote.api.MarvelApiService
import com.example.marveltest.data.remote.domain.mapper.SeriesMapper
import com.example.marveltest.data.repository.MainRepository
import com.example.marveltest.data.repository.MainRepositoryImpl
import com.example.marveltest.databinding.ActivityMainBinding
import com.example.marveltest.ui.adapter.SeriesAdapter
import com.example.marveltest.ui.viewmodels.MainViewModel
import com.example.marveltest.ui.viewmodels.MarvelViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val adapter = SeriesAdapter(mutableListOf(), viewModel)
        binding.recyclerView.adapter = adapter


    }
}