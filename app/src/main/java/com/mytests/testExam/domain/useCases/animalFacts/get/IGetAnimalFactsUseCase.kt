package com.mytests.testExam.domain.useCases.animalFacts.get

import com.mytests.testExam.domain.model.AnimalFacts
import com.mytests.testExam.domain.util.Status
import kotlinx.coroutines.flow.StateFlow

interface IGetAnimalFactsUseCase {
    suspend fun getAnimalFacts(animalType: String, amount: Int): StateFlow<Pair<Status,List<AnimalFacts>>>
}