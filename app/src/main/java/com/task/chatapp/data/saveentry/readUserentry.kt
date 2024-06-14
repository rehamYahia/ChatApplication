package com.task.chatapp.data.saveentry

import kotlinx.coroutines.flow.Flow

class readUserentry(private val localmanger: userlocalmangerinter) {

     operator fun invoke(): Flow<Boolean> {

        return  localmanger.readUserentry()

    }
}