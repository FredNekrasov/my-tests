package com.mytests.testExam.domain.useCases.animalFacts.get.implementation

import com.mytests.testExam.domain.model.AnimalFacts
import com.mytests.testExam.domain.repository.IAnimalFactsRepository
import com.mytests.testExam.domain.useCases.animalFacts.get.IGetAnimalFactsUseCase
import com.mytests.testExam.domain.util.Status
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class GetAnimalFactsUseCase(private val repository: IAnimalFactsRepository) : IGetAnimalFactsUseCase {
    override suspend fun getAnimalFacts(
        animalType: String,amount: Int
    ): StateFlow<Pair<Status,List<AnimalFacts>>> {
        val (status, factsEntity) = repository.getList(animalType,amount).value
        val facts = factsEntity.map { it.toDomain() }
        return MutableStateFlow(status to facts)
    }
}