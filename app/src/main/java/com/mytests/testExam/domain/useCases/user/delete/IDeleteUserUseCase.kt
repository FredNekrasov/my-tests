package com.mytests.testExam.domain.useCases.user.delete

import com.mytests.testExam.domain.model.User

interface IDeleteUserUseCase {
    suspend fun deleteUser(user: User)
}