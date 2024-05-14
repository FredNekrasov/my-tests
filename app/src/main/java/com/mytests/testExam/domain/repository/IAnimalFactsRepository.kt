package com.mytests.testExam.domain.repository

import com.mytests.testExam.domain.model.AnimalFacts
import com.mytests.testExam.domain.util.ConnectionStatus
import kotlinx.coroutines.flow.Flow

interface IAnimalFactsRepository {
    fun getList(animalType: String, amount: Int): Flow<Pair<ConnectionStatus, List<AnimalFacts>>>
    suspend fun updateEntity(animalFacts: AnimalFacts)
}