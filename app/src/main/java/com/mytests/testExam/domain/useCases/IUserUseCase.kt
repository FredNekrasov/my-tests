package com.mytests.testExam.domain.useCases

import com.mytests.testExam.domain.model.User

interface IUserUseCase {
    suspend fun authorization(userName: String, password: String): User?
    suspend fun registration(user: User): User?
    suspend fun deleteUser(user: User)
}