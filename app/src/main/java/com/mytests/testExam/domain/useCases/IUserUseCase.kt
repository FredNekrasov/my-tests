package com.mytests.testExam.domain.useCases

import com.mytests.testExam.domain.model.User

interface IUserUseCase {
    fun authorization(userName: String, password: String): User?
    fun registration(user: User): User?
    fun deleteUser(user: User)
}