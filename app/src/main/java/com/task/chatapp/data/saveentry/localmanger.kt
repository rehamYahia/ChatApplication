package com.task.chatapp.data.saveentry

import kotlinx.coroutines.flow.Flow

 interface localmanger {

        suspend fun saveentry()

        fun readentry(): Flow<Boolean>
    }
