package com.task.chatapp.data.models.loginmodel

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
data class userlogin(

    val id:String?=null,
    val phonenumber:String?=null,
    val profilePictureUrl:String?=null,
    val status:Boolean?=null,
    val username:String?=null
): Parcelable
