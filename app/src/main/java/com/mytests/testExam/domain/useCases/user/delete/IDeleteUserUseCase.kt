package com.mytests.testExam.domain.useCases.user.delete

import com.mytests.testExam.domain.model.User
import com.mytests.testExam.domain.util.UserData

interface IDeleteUserUseCase {
    suspend fun deleteUser(user: User?): UserData
}