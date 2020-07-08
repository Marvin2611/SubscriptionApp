package com.example.subscriptionapp.ui.sublistadd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SubListAddViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is sublist Fragment"
    }
    val text: LiveData<String> = _text
}