package com.mytests.testExam.domain.util

import com.mytests.testExam.domain.model.User

sealed class UserData(val status : AuthStatus, val user : User?) {
    class Success(user : User) : UserData(AuthStatus.SUCCESS, user)
    object ExistingUser : UserData(AuthStatus.EXISTING_USER, null)
    object EmptyUser : UserData(AuthStatus.EMPTY_USER, null)
    object UserNotFound : UserData(AuthStatus.USER_NOT_FOUND, null)
    object Deleted : UserData(AuthStatus.DELETED, null)
}