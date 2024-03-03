package com.mytests.test_exam.data.local.dao

import androidx.room.*
import com.mytests.test_exam.data.local.entities.AnimalFactsEntity

@Dao
interface IAnimalFactsDao {
    @Insert
    fun insert(catFacts: AnimalFactsEntity)
    @Delete
    fun delete(catFacts: AnimalFactsEntity)
    @Query("SELECT * FROM AnimalFactsEntity")
    fun getAll(): List<AnimalFactsEntity>
}