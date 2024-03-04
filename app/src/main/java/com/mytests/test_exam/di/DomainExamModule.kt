package com.mytests.test_exam.di

import com.mytests.test_exam.domain.useCases.IAnimalFactsUseCase
import com.mytests.test_exam.domain.useCases.IUserUseCase
import com.mytests.test_exam.domain.useCases.implementation.AnimalFactsUseCase
import com.mytests.test_exam.domain.useCases.implementation.UserUseCase
import org.koin.dsl.module

val domainExamModule = module {
    factory<IUserUseCase> { UserUseCase(get()) }
    factory<IAnimalFactsUseCase> { AnimalFactsUseCase(get()) }
}