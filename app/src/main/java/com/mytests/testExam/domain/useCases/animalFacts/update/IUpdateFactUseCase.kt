package com.mytests.testExam.domain.useCases.animalFacts.update

import com.mytests.testExam.domain.model.AnimalFacts

interface IUpdateFactUseCase {
    suspend fun updateFact(animalFacts: AnimalFacts)
}