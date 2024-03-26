package com.mytests.testExam.domain.useCases.animalFacts.get

import com.mytests.testExam.domain.model.AnimalFacts
import com.mytests.testExam.domain.util.ConnectionStatus
import kotlinx.coroutines.flow.StateFlow

interface IGetAnimalFactsUseCase {
    suspend fun getAnimalFacts(animalType : String, amount : Int): StateFlow<Pair<ConnectionStatus,List<AnimalFacts>>>
}