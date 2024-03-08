package com.mytests.testExam.domain.useCases.implementation

import com.mytests.testExam.domain.model.User
import com.mytests.testExam.domain.repository.IUserRepository
import com.mytests.testExam.domain.useCases.IUserUseCase

class UserUseCase(private val repository: IUserRepository) : IUserUseCase {
    override suspend fun authorization(userName: String,password: String): User? {
        val entity = repository.getList().find { it.userName == userName && it.password == password } ?: return null
        return entity.toDomain()
    }
    override suspend fun registration(user: User): User? {
        val isUserExist = repository.getList().find { it.userName == user.userName && it.password == user.password }
        if(isUserExist != null) return null
        repository.insert(user.toEntity())
        return user
    }
    override suspend fun deleteUser(user: User) = repository.delete(user.toEntity())
}