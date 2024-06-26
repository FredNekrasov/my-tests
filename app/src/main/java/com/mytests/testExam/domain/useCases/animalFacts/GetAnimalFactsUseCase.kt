package com.mytests.testExam.domain.useCases.animalFacts

import com.mytests.testExam.domain.model.AnimalFacts
import com.mytests.testExam.domain.repository.IAnimalFactsRepository
import com.mytests.testExam.domain.util.ConnectionStatus
import kotlinx.coroutines.flow.Flow

class GetAnimalFactsUseCase(
    private val repository: IAnimalFactsRepository
) {
    operator fun invoke(
        animalType : String, amount : Int
    ): Flow<Pair<ConnectionStatus,List<AnimalFacts>>> = repository.getList(animalType, amount)
}