package com.example.lifecycle.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.lifecycle.data.CounterRepositoryImp
import com.example.lifecycle.presentation.counter.MainViewModel

class ViewModelFactory : ViewModelProvider.Factory {
  @Suppress("UNCHECKED_CAST")
  override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {

    if (modelClass == MainViewModel::class.java) {
      return MainViewModel(repository = CounterRepositoryImp()) as T
    }
    throw IllegalStateException("Unknown ViewModel class")
  }
}