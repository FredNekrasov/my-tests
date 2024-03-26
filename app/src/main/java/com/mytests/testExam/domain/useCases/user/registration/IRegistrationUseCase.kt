package com.mytests.testExam.domain.useCases.user.registration

import com.mytests.testExam.domain.model.User
import com.mytests.testExam.domain.util.UserData

interface IRegistrationUseCase {
    suspend fun registration(user : User): UserData
}