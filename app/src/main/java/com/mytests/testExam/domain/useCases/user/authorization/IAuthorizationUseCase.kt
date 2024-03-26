package com.mytests.testExam.domain.useCases.user.authorization

import com.mytests.testExam.domain.util.UserData

interface IAuthorizationUseCase {
    suspend fun authorization(userName : String, password : String): UserData
}