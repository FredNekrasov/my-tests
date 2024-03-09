package com.mytests.testExam.di


import com.mytests.testExam.domain.useCases.animalFacts.AnimalFactsUseCases
import com.mytests.testExam.domain.useCases.animalFacts.get.IGetAnimalFactsUseCase
import com.mytests.testExam.domain.useCases.animalFacts.get.implementation.GetAnimalFactsUseCase
import com.mytests.testExam.domain.useCases.animalFacts.update.IUpdateFactUseCase
import com.mytests.testExam.domain.useCases.animalFacts.update.implementation.UpdateFactUseCase
import com.mytests.testExam.domain.useCases.user.UserUseCases
import com.mytests.testExam.domain.useCases.user.authorization.IAuthorizationUseCase
import com.mytests.testExam.domain.useCases.user.authorization.implementation.AuthorizationUseCase
import com.mytests.testExam.domain.useCases.user.delete.IDeleteUserUseCase
import com.mytests.testExam.domain.useCases.user.delete.implementation.DeleteUserUseCase
import com.mytests.testExam.domain.useCases.user.registration.IRegistrationUseCase
import com.mytests.testExam.domain.useCases.user.registration.implementation.RegistrationUseCase
import org.koin.dsl.module

val domainExamModule = module {
    factory<IAuthorizationUseCase> { AuthorizationUseCase(get()) }
    factory<IRegistrationUseCase> { RegistrationUseCase(get()) }
    factory<IDeleteUserUseCase> { DeleteUserUseCase(get()) }
    factory { UserUseCases(get(), get(), get()) }

    factory<IGetAnimalFactsUseCase> { GetAnimalFactsUseCase(get()) }
    factory<IUpdateFactUseCase> { UpdateFactUseCase(get()) }
    factory { AnimalFactsUseCases(get(), get()) }
}