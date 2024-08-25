package com.example.lifecycle.presentation.counter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lifecycle.data.CounterRepository

class MainViewModel(
  private val repository: CounterRepository = CounterRepository()
) : ViewModel() {

  val counter: LiveData<Int> = repository.getCounter()

  var incrementBy = 3

  fun increment() {
    repository.incrementCounterBy(incrementBy)
  }
}
