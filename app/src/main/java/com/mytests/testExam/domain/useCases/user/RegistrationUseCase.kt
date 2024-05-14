package com.mytests.testExam.domain.useCases.user

import com.mytests.testExam.domain.model.User
import com.mytests.testExam.domain.repository.IUserRepository
import com.mytests.testExam.domain.util.UserData

class RegistrationUseCase(
    private val repository: IUserRepository
) {
    suspend operator fun invoke(user : User): UserData {
        val isUserExist = repository.getList().find { it.userName == user.userName && it.password == user.password }
        if(isUserExist != null) return UserData.ExistingUser
        repository.insert(user)
        return UserData.Success(user)
    }
}