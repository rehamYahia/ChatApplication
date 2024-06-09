package com.task.chatapp.data.saveentry

class saveentry(

    private val localmanger: localmanger
) {
    suspend operator fun invoke() {
        localmanger.saveentry()
    }


}