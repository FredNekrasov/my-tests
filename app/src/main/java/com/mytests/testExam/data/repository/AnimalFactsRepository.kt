package com.mytests.testExam.data.repository

import com.mytests.testExam.data.local.dao.IAnimalFactsDao
import com.mytests.testExam.data.mappers.toDomain
import com.mytests.testExam.data.mappers.toEntity
import com.mytests.testExam.data.remote.service.IAnimalFactsService
import com.mytests.testExam.domain.model.AnimalFacts
import com.mytests.testExam.domain.repository.IAnimalFactsRepository
import com.mytests.testExam.domain.util.ConnectionStatus
import com.mytests.testExam.domain.util.ConnectionStatus.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.HttpException
import java.io.IOException

class AnimalFactsRepository(
    private val dao: IAnimalFactsDao,
    private val api: IAnimalFactsService
) : IAnimalFactsRepository {
    override suspend fun updateEntity(animalFacts : AnimalFacts) = dao.insert(animalFacts.toEntity())
    override suspend fun getList(
        animalType : String, amount : Int
    ): StateFlow<Pair<ConnectionStatus, List<AnimalFacts>>> {
        val listOfFacts = dao.getAll().map { it.toDomain() }
        val data = MutableStateFlow(LOADING to listOfFacts)
        try {
            val result = api.getCatFacts(animalType, amount)
            if(result == null) data.emit(NO_DATA to listOfFacts)
            else {
                result.forEach {
                    dao.delete(it.toEntity())
                    dao.insert(it.toEntity())
                }
                data.emit(SUCCESS to dao.getAll().map { it.toDomain() })
            }
        } catch (e: HttpException) {
            data.emit(ERROR to listOfFacts)
        } catch (e: IOException) {
            data.emit(ERROR to listOfFacts)
        } catch (e: Exception) {
            data.emit(ERROR to listOfFacts)
        }
        return data
    }
}