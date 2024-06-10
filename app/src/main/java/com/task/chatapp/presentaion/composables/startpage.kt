package com.task.chatapp.presentaion.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.task.chatapp.R
import com.task.chatapp.data.saveentry.on_obordingevent
import com.task.chatapp.ui.theme.poppins_bold
import com.task.chatapp.ui.theme.poppins_regular

@Composable
fun StartPage(event:(on_obordingevent)->Unit){
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

        Text(text = "Talky", fontSize = 29.sp, fontFamily = poppins_bold)

        Spacer(modifier = Modifier.height(30.dp))

        Image(painter = painterResource(id = R.drawable.talktimage), modifier = Modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth()
             ,contentDescription ="" , contentScale = ContentScale.Crop)
        Spacer(modifier = Modifier.height(50.dp))
        Text(text = "Stay connected ", modifier = Modifier.padding(end = 20.dp) ,fontSize = 28.sp, fontFamily = poppins_bold)
        Text(text = "with your friends ", modifier = Modifier.padding(end = 11.dp) ,fontSize = 28.sp, fontFamily = poppins_bold)
        Text(text = "and family", modifier = Modifier.padding(end = 100.dp) ,fontSize = 28.sp, fontFamily = poppins_bold)

        Row (){
            Image(painter = painterResource(id = R.drawable.check), modifier = Modifier
                .height(25.dp)
                .width(25.dp),contentDescription = "check")
            Text(text = "Secure, private messaging",fontSize = 18.sp, fontFamily = poppins_regular)

        }
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick ={event(on_obordingevent.saveappentry)} , modifier = Modifier.fillMaxWidth(0.7f).height(50.dp),colors = ButtonDefaults.buttonColors(containerColor = colorResource(
            id = R.color.primart_color
        ), contentColor = Color.Black)) {

            Text(text = "Get Started", fontSize = 22.sp,fontFamily = poppins_bold)

        }
        

    }


}