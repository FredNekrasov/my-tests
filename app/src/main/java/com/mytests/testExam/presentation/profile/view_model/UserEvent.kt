package com.mytests.testExam.presentation.profile.view_model

import com.mytests.testExam.domain.model.User

sealed class UserEvent {
    data class Authorization(val login : String, val password : String) : UserEvent()
    data class Registration(val user : User) : UserEvent()
    data object DeleteUser : UserEvent()
}