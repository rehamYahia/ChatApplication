package com.task.chatapp.presentaion.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.task.chatapp.data.saveentry.myusersaveorread
import com.task.chatapp.data.saveentry.on_obordingevent
import com.task.chatapp.data.saveentry.on_userevent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class userviewmodel@Inject constructor(
    private val myusersaveorread: myusersaveorread
): ViewModel() {

    fun myevent(event: on_userevent) {
        when (event) {
            is on_userevent.saveuserentry -> {
                saveuserentry()

            }

        }
    }



    private fun saveuserentry() {
        viewModelScope.launch {
            myusersaveorread.savuserdata()
        }
    }

}