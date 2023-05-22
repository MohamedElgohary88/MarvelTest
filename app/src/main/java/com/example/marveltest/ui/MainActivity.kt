package com.example.marveltest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.marveltest.DepndancyContainer
import com.example.marveltest.R
import com.example.marveltest.data.local.SeriesDao
import com.example.marveltest.data.local.SeriesDatabase
import com.example.marveltest.data.mapper.SeriesMapper
import com.example.marveltest.data.remote.api.Api
import com.example.marveltest.data.remote.api.MarvelApiService
import com.example.marveltest.data.repository.MainRepository
import com.example.marveltest.data.repository.MainRepositoryImpl
import com.example.marveltest.databinding.ActivityMainBinding
import com.example.marveltest.ui.adapter.SeriesAdapter
import com.example.marveltest.ui.viewmodels.MainViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val container = DepndancyContainer(applicationContext)

        val repository =
            MainRepositoryImpl(container.apiService, container.seriesMapper, container.seriesDao)

        viewModel = MainViewModel(repository)
        SeriesDatabase.getInstance(applicationContext)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        val adapter = SeriesAdapter(mutableListOf(), viewModel)
        binding.recyclerView.adapter = adapter
    }
}