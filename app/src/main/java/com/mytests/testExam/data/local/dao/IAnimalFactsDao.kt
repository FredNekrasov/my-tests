package com.mytests.testExam.data.local.dao

import androidx.room.*
import com.mytests.testExam.data.local.entities.AnimalFactsEntity

@Dao
interface IAnimalFactsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(catFacts: AnimalFactsEntity)
    @Delete
    suspend fun delete(catFacts: AnimalFactsEntity)
    @Query("SELECT * FROM AnimalFactsEntity")
    suspend fun getAll(): List<AnimalFactsEntity>
}