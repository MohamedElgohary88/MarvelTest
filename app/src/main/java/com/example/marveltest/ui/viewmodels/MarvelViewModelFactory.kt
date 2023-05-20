package com.example.marveltest.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.marveltest.data.repository.MainRepository

@Suppress("UNREACHABLE_CODE")
class MarvelViewModelFactory(private val repository: MainRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass == MainViewModel::class.java) {
            return MainViewModel(repository) as T
        }
        throw Throwable("Error")
    }
}