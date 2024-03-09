package com.mytests.testExam.domain.useCases.user

import com.mytests.testExam.domain.useCases.user.authorization.IAuthorizationUseCase
import com.mytests.testExam.domain.useCases.user.delete.IDeleteUserUseCase
import com.mytests.testExam.domain.useCases.user.registration.IRegistrationUseCase

data class UserUseCases(
    val auth: IAuthorizationUseCase,
    val reg: IRegistrationUseCase,
    val del: IDeleteUserUseCase
)