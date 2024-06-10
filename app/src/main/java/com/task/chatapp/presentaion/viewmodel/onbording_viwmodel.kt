package com.task.chatapp.presentaion.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.task.chatapp.data.saveentry.myappsaveorread
import com.task.chatapp.data.saveentry.on_obordingevent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class onbording_viwmodel @Inject constructor(
    private val myappsaveorread: myappsaveorread
) : ViewModel() {

    fun myevent(event: on_obordingevent) {
        when (event) {
            is on_obordingevent.saveappentry -> {
                saveappentry()
            }
        }
    }

    private fun saveappentry() {
        viewModelScope.launch {
            myappsaveorread.saveentry()
        }

    }

}