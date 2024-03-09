package com.mytests.testExam.domain.useCases.user.registration

import com.mytests.testExam.domain.model.User

interface IRegistrationUseCase {
    suspend fun registration(user: User): User?
}