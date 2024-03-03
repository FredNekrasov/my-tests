package com.mytests.test_exam.domain.repository

import com.mytests.test_exam.data.local.entities.AnimalFactsEntity
import com.mytests.test_exam.domain.util.Status
import kotlinx.coroutines.flow.StateFlow

interface IAnimalFactsRepository {
    suspend fun getList(animalType: String, amount: Int): StateFlow<Pair<Status,List<AnimalFactsEntity>>>
    suspend fun updateEntity(animalFacts: AnimalFactsEntity)
}