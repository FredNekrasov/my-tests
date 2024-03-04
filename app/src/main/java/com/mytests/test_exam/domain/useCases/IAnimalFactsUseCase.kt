package com.mytests.test_exam.domain.useCases

import com.mytests.test_exam.domain.model.AnimalFacts
import com.mytests.test_exam.domain.util.Status
import kotlinx.coroutines.flow.StateFlow

interface IAnimalFactsUseCase {
    suspend fun getAnimalFacts(animalType: String, amount: Int): StateFlow<Pair<Status,List<AnimalFacts>>>
    suspend fun updateFact(animalFacts: AnimalFacts)
}