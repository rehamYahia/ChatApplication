package com.task.chatapp.domain.repositories.login

import android.app.Activity
import com.task.chatapp.data.models.Resource
import com.task.chatapp.data.models.loginmodel.userlogin
import kotlinx.coroutines.flow.Flow

interface LoginWithPhone {

    fun loginWithPhone(phone: String,activity: Activity?):Flow<Resource<userlogin>>

    suspend fun verifymycode(verificationId: String, code: String)
}