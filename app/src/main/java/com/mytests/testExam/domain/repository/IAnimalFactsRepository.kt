package com.mytests.testExam.domain.repository

import com.mytests.testExam.data.local.entities.AnimalFactsEntity
import com.mytests.testExam.domain.util.Status
import kotlinx.coroutines.flow.StateFlow

interface IAnimalFactsRepository {
    suspend fun getList(animalType: String, amount: Int): StateFlow<Pair<Status,List<AnimalFactsEntity>>>
    suspend fun updateEntity(animalFacts: AnimalFactsEntity)
}