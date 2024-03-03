package com.mytests.test_exam.di

import com.mytests.test_exam.domain.use_cases.IAnimalFactsUseCase
import com.mytests.test_exam.domain.use_cases.IUserUseCase
import com.mytests.test_exam.domain.use_cases.implementation.AnimalFactsUseCase
import com.mytests.test_exam.domain.use_cases.implementation.UserUseCase
import org.koin.dsl.module

val domainExamModule = module {
    factory<IUserUseCase> { UserUseCase(get()) }
    factory<IAnimalFactsUseCase> { AnimalFactsUseCase(get()) }
}