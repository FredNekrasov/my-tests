package com.mytests.testExam.data.repository

import com.mytests.testExam.data.local.dao.IAnimalFactsDao
import com.mytests.testExam.data.mappers.toDomain
import com.mytests.testExam.data.mappers.toEntity
import com.mytests.testExam.data.remote.dto.AnimalFactsDTO
import com.mytests.testExam.domain.model.AnimalFacts
import com.mytests.testExam.domain.repository.IAnimalFactsRepository
import com.mytests.testExam.domain.util.ConnectionStatus
import com.mytests.testExam.domain.util.ConnectionStatus.*
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.*
import io.ktor.client.request.get
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AnimalFactsRepository(
    private val dao: IAnimalFactsDao,
    private val client : HttpClient
) : IAnimalFactsRepository {
    override suspend fun updateEntity(animalFacts : AnimalFacts) = dao.insert(animalFacts.toEntity())
    override fun getList(
        animalType : String, amount : Int
    ): Flow<Pair<ConnectionStatus, List<AnimalFacts>>> = flow {
        val listOfFacts = dao.getAll().map { it.toDomain() }
        emit(LOADING to listOfFacts)
        if(animalType.isEmpty() || animalType.isBlank() || amount <= 1) {
            emit(SUCCESS to listOfFacts)
        } else {
            try {
                val result = client.get("/facts/random?animal_type=$animalType&amount=$amount").body<List<AnimalFactsDTO>?>()
                if(result.isNullOrEmpty()) {
                    emit(NO_DATA to listOfFacts)
                } else {
                    result.forEach {
                        dao.delete(it.toEntity())
                        dao.insert(it.toEntity())
                    }
                    emit(SUCCESS to dao.getAll().map { it.toDomain() })
                }
            } catch (e: RedirectResponseException) {
                emit(ERROR to listOfFacts)
            } catch (e: ClientRequestException) {
                emit(ERROR to listOfFacts)
            } catch (e: ServerResponseException) {
                emit(ERROR to listOfFacts)
            }
        }
    }
}