package com.example.lifecycle.presentation.counter

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.lifecycle.domain.CounterRepository

class MainViewModel(
  private val repository: CounterRepository
) : ViewModel() {

  val counter: LiveData<Int> = repository.getCounter()

  var incrementBy = 3

  fun increment() {
    repository.incrementCounterBy(incrementBy)
  }
}
