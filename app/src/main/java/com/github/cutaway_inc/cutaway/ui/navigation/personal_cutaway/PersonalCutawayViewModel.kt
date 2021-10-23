package com.github.cutaway_inc.cutaway.ui.navigation.personal_cutaway

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PersonalCutawayViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is cutaway Fragment"
    }
    val text: LiveData<String> = _text
}