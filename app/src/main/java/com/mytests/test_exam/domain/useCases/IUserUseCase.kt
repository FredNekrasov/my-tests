package com.mytests.test_exam.domain.useCases

import com.mytests.test_exam.domain.model.User

interface IUserUseCase {
    fun authorization(userName: String, password: String): User?
    fun registration(user: User): User?
    fun deleteUser(user: User)
}