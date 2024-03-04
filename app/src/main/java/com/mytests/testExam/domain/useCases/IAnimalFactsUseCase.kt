package com.mytests.testExam.domain.useCases

import com.mytests.testExam.domain.model.AnimalFacts
import com.mytests.testExam.domain.util.Status
import kotlinx.coroutines.flow.StateFlow

interface IAnimalFactsUseCase {
    suspend fun getAnimalFacts(animalType: String, amount: Int): StateFlow<Pair<Status,List<AnimalFacts>>>
    suspend fun updateFact(animalFacts: AnimalFacts)
}