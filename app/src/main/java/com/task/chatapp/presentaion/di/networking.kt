package com.task.chatapp.presentaion.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.task.chatapp.data.repositories.loginimpl.loginwithphoneImple
import com.task.chatapp.domain.repositories.login.LoginWithPhone
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object networking {

    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }

    @Provides
    @Singleton
    fun provideFirebaseFirestore(): FirebaseFirestore {
        return FirebaseFirestore.getInstance()
    }

    @Provides
    @Singleton
    fun provideloginwithphone(auth: FirebaseAuth, firestore: FirebaseFirestore):LoginWithPhone{
        return loginwithphoneImple(firestore,auth)
    }


}