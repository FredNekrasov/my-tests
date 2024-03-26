package com.mytests.testExam.domain.useCases.user.authorization.implementation

import com.mytests.testExam.domain.repository.IUserRepository
import com.mytests.testExam.domain.useCases.user.authorization.IAuthorizationUseCase
import com.mytests.testExam.domain.util.UserData

class AuthorizationUseCase(
    private val repository: IUserRepository
) : IAuthorizationUseCase {
    override suspend fun authorization(userName : String, password : String): UserData {
        val user = repository.getList()
            .find { it.userName == userName && it.password == password } ?: return UserData.UserNotFound
        return UserData.Success(user)
    }
}