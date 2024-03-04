package com.mytests.testExam.di

import com.mytests.testExam.domain.useCases.IAnimalFactsUseCase
import com.mytests.testExam.domain.useCases.IUserUseCase
import com.mytests.testExam.domain.useCases.implementation.AnimalFactsUseCase
import com.mytests.testExam.domain.useCases.implementation.UserUseCase
import org.koin.dsl.module

val domainExamModule = module {
    factory<IUserUseCase> { UserUseCase(get()) }
    factory<IAnimalFactsUseCase> { AnimalFactsUseCase(get()) }
}