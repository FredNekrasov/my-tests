package com.mytests.testExam.domain.useCases.animalFacts

import com.mytests.testExam.domain.model.AnimalFacts
import com.mytests.testExam.domain.repository.IAnimalFactsRepository

class UpdateFactUseCase(
    private val repository: IAnimalFactsRepository
) {
    suspend operator fun invoke(animalFacts: AnimalFacts) = repository.updateEntity(animalFacts)
}