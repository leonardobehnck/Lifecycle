package com.example.lifecycle.presentation.counter

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.lifecycle.data.CounterRepository

class MainViewModel(
  private val repository: CounterRepository
) : ViewModel() {

  val counter: LiveData<Int> = repository.getCounter()

  fun increment() {
    repository.incrementCounterBy(1)
  }
}
