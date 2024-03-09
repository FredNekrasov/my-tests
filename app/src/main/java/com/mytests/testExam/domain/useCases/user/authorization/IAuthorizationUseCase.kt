package com.mytests.testExam.domain.useCases.user.authorization

import com.mytests.testExam.domain.model.User

interface IAuthorizationUseCase {
    suspend fun authorization(userName: String, password: String): User?
}