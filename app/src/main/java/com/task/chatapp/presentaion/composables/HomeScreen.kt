package com.task.chatapp.presentaion.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(){
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Homescreen", modifier = Modifier.padding(top = 40.dp))
    }

}