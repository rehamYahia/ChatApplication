package com.task.chatapp.data.saveentry

class saveuserentry( private val localmanger: userlocalmangerinter) {

    suspend operator fun invoke() {
        localmanger.saveuserentry()
    }
}