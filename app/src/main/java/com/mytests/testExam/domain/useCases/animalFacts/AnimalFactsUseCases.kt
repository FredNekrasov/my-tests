package com.mytests.testExam.domain.useCases.animalFacts

import com.mytests.testExam.domain.useCases.animalFacts.get.IGetAnimalFactsUseCase
import com.mytests.testExam.domain.useCases.animalFacts.update.IUpdateFactUseCase

data class AnimalFactsUseCases(
    val getFacts: IGetAnimalFactsUseCase,
    val updateFact: IUpdateFactUseCase
)