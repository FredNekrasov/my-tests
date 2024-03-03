package com.mytests.test_exam.domain.use_cases

import com.mytests.test_exam.domain.model.AnimalFacts
import com.mytests.test_exam.domain.util.Status
import kotlinx.coroutines.flow.StateFlow

interface IAnimalFactsUseCase {
    suspend fun getAnimalFacts(animalType: String, amount: Int): StateFlow<Pair<Status,List<AnimalFacts>>>
}