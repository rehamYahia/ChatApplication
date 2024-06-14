package com.task.chatapp.data.saveentry

import kotlinx.coroutines.flow.Flow

interface userlocalmangerinter {

    suspend fun saveuserentry()

    fun readUserentry(): Flow<Boolean>
}