package com.example.subscriptionapp.ui.statistics

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StatisticsViewModel : ViewModel(){


    private val monthValue = MutableLiveData<String>().apply {
        value = "14.44 "
    }
    val costPerMonthValue: LiveData<String> = monthValue
    private val yearValue = MutableLiveData<String>().apply {
        value = "14.44 "
    }
    val costPerYearValue: LiveData<String> = yearValue
    private val mostExpensiveValue = MutableLiveData<String>().apply {
        value = "14.44 "
    }
    val costOfMostExpensiveValue: LiveData<String> = mostExpensiveValue
    private val cheapestValue = MutableLiveData<String>().apply {
        value = "14.44 "
    }
    val costOfCheapestValue: LiveData<String> = cheapestValue
}