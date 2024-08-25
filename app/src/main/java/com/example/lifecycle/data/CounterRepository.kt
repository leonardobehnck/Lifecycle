package com.example.lifecycle.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class  CounterRepository {
  private val counter = MutableLiveData(0)

  fun getCounter(): LiveData<Int> = counter

  fun incrementCounterBy(increment: Int) {
    val number = counter.value ?: 0
    counter.value = number + increment
  }
}
