package com.mytests.testExam.domain.useCases.user.delete.implementation

import com.mytests.testExam.domain.model.User
import com.mytests.testExam.domain.repository.IUserRepository
import com.mytests.testExam.domain.useCases.user.delete.IDeleteUserUseCase
import com.mytests.testExam.domain.util.UserData

class DeleteUserUseCase(
    private val repository: IUserRepository
) : IDeleteUserUseCase {
    override suspend fun deleteUser(user: User?) : UserData {
        if(user == null) return UserData.EmptyUser
        repository.delete(user)
        return UserData.Deleted
    }
}