package com.mytests.testExam.data.local.dao

import androidx.room.*
import com.mytests.testExam.data.local.entities.UserEntity

@Dao
interface IUserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: UserEntity)
    @Delete
    suspend fun delete(user: UserEntity)
    @Query("SELECT * FROM userentity")
    suspend fun getAll(): List<UserEntity>
}