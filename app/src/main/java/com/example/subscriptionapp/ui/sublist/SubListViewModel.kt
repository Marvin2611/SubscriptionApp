package com.example.subscriptionapp.ui.sublist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SubListViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is sublist Fragment"
    }
    val text: LiveData<String> = _text
}