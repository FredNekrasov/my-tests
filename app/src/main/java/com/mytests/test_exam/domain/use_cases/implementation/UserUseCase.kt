package com.mytests.test_exam.domain.use_cases.implementation

import com.mytests.test_exam.domain.model.User
import com.mytests.test_exam.domain.repository.IUserRepository
import com.mytests.test_exam.domain.use_cases.IUserUseCase

class UserUseCase(private val repository: IUserRepository) : IUserUseCase {
    override fun authorization(userName: String,password: String): User? {
        val entity = repository.getList().find { it.userName == userName && it.password == password } ?: return null
        return entity.toDomain()
    }
    override fun registration(user: User): User? {
        val isUserExist = repository.getList().find { it.userName == user.userName && it.password == user.password }
        if(isUserExist != null) return null
        repository.insert(user.toEntity())
        return user
    }
    override fun deleteUser(user: User) = repository.delete(user.toEntity())
}