package com.mytests.test_exam.data.remote.service

import com.mytests.test_exam.data.remote.dto.AnimalFactsDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface IAnimalFactsService {
    @GET("/facts/random")
    suspend fun getCatFacts(
        @Query("animal_type") animalType: String,
        @Query("amount") amount: Int
    ): List<AnimalFactsDTO>?
    companion object {
        const val BASE_URL = "https://cat-fact.herokuapp.com"
    }
}