package com.github.cutaway_inc.cutaway.ui.cutaway

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CutawayViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Stub"
    }
    val text: LiveData<String> = _text
}