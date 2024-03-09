package com.mytests.testExam.domain.useCases.animalFacts.update.implementation

import com.mytests.testExam.domain.model.AnimalFacts
import com.mytests.testExam.domain.repository.IAnimalFactsRepository
import com.mytests.testExam.domain.useCases.animalFacts.update.IUpdateFactUseCase

class UpdateFactUseCase(private val repository: IAnimalFactsRepository) : IUpdateFactUseCase {
    override suspend fun updateFact(animalFacts: AnimalFacts) = repository.updateEntity(animalFacts.toEntity())
}