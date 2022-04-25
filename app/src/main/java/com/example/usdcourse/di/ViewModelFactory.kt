package com.example.usdcourse.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.usdcourse.app.App

class ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val viewModel = App.componentApp.mapModels[modelClass]
        return viewModel as T
    }
}