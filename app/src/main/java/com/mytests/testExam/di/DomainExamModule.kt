package com.mytests.testExam.di

import com.mytests.testExam.domain.useCases.animalFacts.*
import com.mytests.testExam.domain.useCases.user.*
import org.koin.dsl.module

val domainExamModule = module {
    factory { AuthorizationUseCase(get()) }
    factory { RegistrationUseCase(get()) }
    factory { DeleteUserUseCase(get()) }
    factory { UserUseCases(get(), get(), get()) }

    factory { GetAnimalFactsUseCase(get()) }
    factory { UpdateFactUseCase(get()) }
    factory { AnimalFactsUseCases(get(), get()) }
}