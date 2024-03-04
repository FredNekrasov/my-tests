package com.mytests.test_exam.domain.useCases.implementation

import com.mytests.test_exam.domain.model.AnimalFacts
import com.mytests.test_exam.domain.repository.IAnimalFactsRepository
import com.mytests.test_exam.domain.useCases.IAnimalFactsUseCase
import com.mytests.test_exam.domain.util.Status
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AnimalFactsUseCase(private val repository: IAnimalFactsRepository) : IAnimalFactsUseCase {
    override suspend fun getAnimalFacts(animalType: String,amount: Int): StateFlow<Pair<Status,List<AnimalFacts>>> {
        val (status, factsEntity) = repository.getList(animalType,amount).value
        val facts = factsEntity.map { it.toDomain() }
        return MutableStateFlow(status to facts)
    }
    override suspend fun updateFact(animalFacts: AnimalFacts) = repository.updateEntity(animalFacts.toEntity())
}