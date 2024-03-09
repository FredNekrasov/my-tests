package com.mytests.testExam.domain.useCases.user.authorization.implementation

import com.mytests.testExam.domain.model.User
import com.mytests.testExam.domain.repository.IUserRepository
import com.mytests.testExam.domain.useCases.user.authorization.IAuthorizationUseCase

class AuthorizationUseCase(private val repository: IUserRepository) : IAuthorizationUseCase {
    override suspend fun authorization(userName: String,password: String): User? {
        val entity = repository.getList().find { it.userName == userName && it.password == password } ?: return null
        return entity.toDomain()
    }
}