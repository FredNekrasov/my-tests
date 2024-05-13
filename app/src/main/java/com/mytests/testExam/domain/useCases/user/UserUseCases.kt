package com.mytests.testExam.domain.useCases.user

data class UserUseCases(
    val authorizationUseCase : AuthorizationUseCase,
    val registrationUseCase : RegistrationUseCase,
    val deleteUserUseCase : DeleteUserUseCase
)