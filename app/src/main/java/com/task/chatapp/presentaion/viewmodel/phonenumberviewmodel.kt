package com.task.chatapp.presentaion.viewmodel

import android.app.Activity
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.task.chatapp.data.models.Resource
import com.task.chatapp.data.models.loginmodel.userlogin
import com.task.chatapp.domain.repositories.login.LoginWithPhone
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class phonenumberviewmodel @Inject constructor(
    private val repo:LoginWithPhone
):ViewModel() {

    var phonenumber by mutableStateOf("")
        private set

//    var verification_Id by mutableStateOf("")
//        private set
//
//    var verificationCode by mutableStateOf("")
//        private set



//   val isnumber_valid:Boolean= phonenumber.isNotEmpty()

    private val _loginState = MutableSharedFlow<Resource<userlogin>>()
    val loginState: SharedFlow<Resource<userlogin>> = _loginState.asSharedFlow()

    fun loginwithphone(avtivity:Activity){

        viewModelScope.launch(Dispatchers.IO) {
            val number = "+20${phonenumber}"
            Log.d("number", number)
            if (number.isNotEmpty()){

                repo.loginWithPhone(number, activity = avtivity).collect{
                    when(it){
                        is Resource.Success->{
                            _loginState.emit(Resource.Success(it.data!!))
                        }
//                        is Resource.Error->{
//                            _loginState.emit(Resource.Error(it.exception!!))
//                        }

                        else -> {
                            _loginState.emit(it)

                        }

                    }
                    }


            }
            else{
                _loginState.emit(Resource.Error(Exception("invalid number yasta")))

            }

        }


    }


//    fun setVerificationId(id: String) {
//        verification_Id = id
//    }
//
//    fun setVerificationCode(code: String) {
//        verificationCode = code
//    }

    fun myverifyCode() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
//                repo.verifymycode(verification_Id,verificationCode)
            } catch (e: Exception) {
                _loginState.emit(Resource.Error(e))
            }
        }
    }






    fun text(text2:String){
        phonenumber=text2

    }
}