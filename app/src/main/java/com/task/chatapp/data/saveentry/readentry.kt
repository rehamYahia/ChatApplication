package com.task.chatapp.data.saveentry

import kotlinx.coroutines.flow.Flow

class readentry(
    private val localmanager: localmanger
) {

    operator fun invoke(): Flow<Boolean> {
        return localmanager.readentry()
    }
}