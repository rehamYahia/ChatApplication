package com.task.chatapp.presentaion.di

import android.app.Application
import com.task.chatapp.data.saveentry.localmanager
import com.task.chatapp.data.saveentry.localmanger
import com.task.chatapp.data.saveentry.myappsaveorread
import com.task.chatapp.data.saveentry.myusersaveorread
import com.task.chatapp.data.saveentry.readUserentry
import com.task.chatapp.data.saveentry.readentry
import com.task.chatapp.data.saveentry.saveentry
import com.task.chatapp.data.saveentry.saveuserentry
import com.task.chatapp.data.saveentry.userlocalmanger
import com.task.chatapp.data.saveentry.userlocalmangerinter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object module {
    @Provides
    @Singleton
    fun providelocalmanger(app: Application): localmanger {
        return localmanager(app)
    }

    @Provides
    @Singleton
    fun provideuserlocalmanger(app: Application): userlocalmangerinter {
        return userlocalmanger(app)
    }

    @Provides
    @Singleton
    fun providesaveorreaddata(localmanager: localmanger): myappsaveorread {
        return myappsaveorread(saveentry(localmanager), readentry(localmanager)
        )
    }

    @Provides
    @Singleton
    fun providesaveorreaduserdata(userlocalmanager: userlocalmangerinter): myusersaveorread {
        return myusersaveorread(saveuserentry(userlocalmanager),
            readUserentry(userlocalmanager)
        )
    }
}
