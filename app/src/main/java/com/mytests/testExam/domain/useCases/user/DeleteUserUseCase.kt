package com.mytests.testExam.domain.useCases.user

import com.mytests.testExam.domain.model.User
import com.mytests.testExam.domain.repository.IUserRepository
import com.mytests.testExam.domain.util.UserData

class DeleteUserUseCase(
    private val repository: IUserRepository
) {
    suspend operator fun invoke(user: User?) : UserData {
        if(user == null) return UserData.EmptyUser
        repository.delete(user)
        return UserData.Deleted
    }
}