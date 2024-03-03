package com.mytests.test_exam.domain.use_cases

import com.mytests.test_exam.domain.model.User

interface IUserUseCase {
    fun authorization(userName: String, password: String): User?
    fun registration(user: User): User?
    fun deleteUser(user: User)
}