package com.mytests.test_exam.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mytests.test_exam.data.local.dao.IAnimalFactsDao
import com.mytests.test_exam.data.local.dao.IUserDao
import com.mytests.test_exam.data.local.entities.AnimalFactsEntity
import com.mytests.test_exam.data.local.entities.UserEntity

@Database(
    entities = [UserEntity::class,AnimalFactsEntity::class],
    version = 2,
    exportSchema = false
)
abstract class MainDB : RoomDatabase() {
    abstract val userDao: IUserDao
    abstract val animalFactsDao: IAnimalFactsDao
    companion object {
        const val DATABASE_NAME = "exam_db"
    }
}