package com.task.chatapp.presentaion.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.task.chatapp.R
import com.task.chatapp.data.saveentry.on_obordingevent
import com.task.chatapp.presentaion.viewmodel.phonenumberviewmodel
import com.task.chatapp.ui.theme.poppins_bold
import com.task.chatapp.ui.theme.poppins_regular
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun PhoneNumberLogin(vmodel:phonenumberviewmodel= hiltViewModel()){


    PhoneNumberBody(ontext = vmodel::text)
}


@Composable
fun PhoneNumberBody(ontext: (String) -> Unit){
    Column(modifier = Modifier.padding(top = 60.dp)) {
        Text(text = "Enter your phone number", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center,fontFamily = poppins_bold,fontSize = 20.sp)

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Please enter your phone number to verify your account", modifier = Modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth(), textAlign = TextAlign.Center,fontFamily = poppins_regular,fontSize = 15.sp)

        Spacer(modifier = Modifier.height(30.dp))

        Row (){
            Box(modifier = Modifier
                .padding(top = 25.dp, start = 33.dp)
                .width(120.dp)

                .clip(shape = RoundedCornerShape(10.dp))) {
                Row {
                    Image(painter = painterResource(id = R.drawable.egypt), modifier = Modifier
                        .width(40.dp)
                        .height(40.dp) ,contentDescription ="egypt flag")
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = "+20",fontFamily = poppins_bold,fontSize = 16.sp, modifier = Modifier.padding(top = 9.dp))

                }

            }


            MyTextField(modifier = Modifier.width(290.dp), ontext = ontext)

        }

        Spacer(modifier = Modifier.height(50.dp))

        Button(onClick ={} , modifier = Modifier.fillMaxWidth(0.7f).height(50.dp).align(Alignment.CenterHorizontally), shape = RoundedCornerShape(7.dp),colors = ButtonDefaults.buttonColors(containerColor = colorResource(
            id = R.color.primart_color
        ), contentColor = Color.White)) {

            Text(text = "Continue", fontSize = 16.sp,fontFamily = poppins_bold)

        }



    }

}




@Composable
fun MyTextField(model:phonenumberviewmodel= hiltViewModel(), modifier: Modifier = Modifier,ontext:(String)->Unit) {



    Box(modifier = modifier.padding(horizontal = 10.dp, vertical = 15.dp)) {
        TextField(

            modifier = Modifier
                .fillMaxWidth()
                .shadow(4.dp, RoundedCornerShape(10.dp))
                .clip(AbsoluteRoundedCornerShape(7.dp)),
                value = model.phonenumber,



            onValueChange = {
               ontext(it)

            },
            maxLines = 1,
            singleLine = true,
            colors = TextFieldDefaults.colors(
                Color.Gray,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = colorResource(id = R.color.light_grey)
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),

        )
    }

}
