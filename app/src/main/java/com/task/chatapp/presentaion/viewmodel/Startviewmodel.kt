package com.task.chatapp.presentaion.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.task.chatapp.data.saveentry.myappsaveorread
import com.task.chatapp.utilis.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.time.delay
import java.time.Duration
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.O)
@HiltViewModel
class startviewmodel@Inject constructor(
    private val myappsaveorread: myappsaveorread
): ViewModel() {
    var splashcondition by mutableStateOf(true)
        private set

    var startdistination by mutableStateOf(Constants.onbording)
        private set
    init {
        myappsaveorread.readentry().onEach {shouldstartfromhomescreen->
            if(shouldstartfromhomescreen){

                startdistination = Constants.sartscreen
            }
            else {
                startdistination = Constants.onbording
            }


            splashcondition=false



        }.launchIn(viewModelScope)
    }




}