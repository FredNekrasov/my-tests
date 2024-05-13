package com.mytests.testExam.domain.useCases.user

import com.mytests.testExam.domain.repository.IUserRepository
import com.mytests.testExam.domain.util.UserData

class AuthorizationUseCase(
    private val repository: IUserRepository
) {
    suspend operator fun invoke(userName : String, password : String): UserData {
        val user = repository.getList()
            .find { it.userName == userName && it.password == password } ?: return UserData.UserNotFound
        return UserData.Success(user)
    }
}