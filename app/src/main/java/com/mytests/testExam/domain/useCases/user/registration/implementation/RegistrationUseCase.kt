package com.mytests.testExam.domain.useCases.user.registration.implementation

import com.mytests.testExam.domain.model.User
import com.mytests.testExam.domain.repository.IUserRepository
import com.mytests.testExam.domain.useCases.user.registration.IRegistrationUseCase
import com.mytests.testExam.domain.util.UserData

class RegistrationUseCase(
    private val repository: IUserRepository
) : IRegistrationUseCase {
    override suspend fun registration(user : User): UserData {
        val isUserExist = repository.getList().find { it.userName == user.userName && it.password == user.password }
        if(isUserExist != null) return UserData.ExistingUser
        repository.insert(user)
        return UserData.Success(user)
    }
}