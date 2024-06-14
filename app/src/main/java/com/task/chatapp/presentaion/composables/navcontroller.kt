package com.task.chatapp.presentaion.composables

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.task.chatapp.data.saveentry.on_userevent
import com.task.chatapp.presentaion.viewmodel.onbording_viwmodel
import com.task.chatapp.presentaion.viewmodel.userviewmodel
import com.task.chatapp.utilis.Constants

@Composable

fun Mynaviation(startdistination:String) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startdistination) {
        composable(route = Constants.onbording) {
            val model: onbording_viwmodel = hiltViewModel()

            StartPage(event = model::myevent)
        }
        composable(route = Constants.sartscreen) {
            val usermodel: userviewmodel = hiltViewModel()
            PhoneNumberLogin(event = usermodel::myevent, navController = navController)
        }
        composable(route = Constants.verificationpage) {
            VerificationCode()
        }

    }
}