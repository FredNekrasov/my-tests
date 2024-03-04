package com.mytests.testExam.data.repository

import com.mytests.testExam.data.local.dao.IAnimalFactsDao
import com.mytests.testExam.data.local.entities.AnimalFactsEntity
import com.mytests.testExam.data.remote.service.IAnimalFactsService
import com.mytests.testExam.domain.repository.IAnimalFactsRepository
import com.mytests.testExam.domain.util.Status
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.HttpException
import java.io.IOException

class AnimalFactsRepository(
    private val dao: IAnimalFactsDao,
    private val api: IAnimalFactsService
) : IAnimalFactsRepository {
    override suspend fun getList(animalType: String,amount: Int): StateFlow<Pair<Status,List<AnimalFactsEntity>>> {
        val listOfFacts = dao.getAll()
        val data = MutableStateFlow(Status.LOADING to listOfFacts)
        try {
            val result = api.getCatFacts(animalType, amount)
            if(result == null) data.emit(Status.NO_DATA to listOfFacts)
            else {
                result.forEach {
                    dao.delete(AnimalFactsEntity(it.text,animalType,false))
                    dao.insert(AnimalFactsEntity(it.text,animalType,false))
                }
                data.emit(Status.SUCCESS to dao.getAll())
            }
        } catch (e: Exception) {
            data.emit(Status.ERROR to listOfFacts)
        } catch (e: HttpException) {
            data.emit(Status.ERROR to listOfFacts)
        } catch (e: IOException) {
            data.emit(Status.ERROR to listOfFacts)
        }
        return data
    }
    override suspend fun updateEntity(animalFacts: AnimalFactsEntity) = dao.insert(animalFacts)
}