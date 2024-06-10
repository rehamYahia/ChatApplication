package com.task.chatapp.presentaion.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class phonenumberviewmodel:ViewModel() {

    var phonenumber by mutableStateOf("")
        private set



    fun text(text2:String){
        phonenumber=text2

    }
}