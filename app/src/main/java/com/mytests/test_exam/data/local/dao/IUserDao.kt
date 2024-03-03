package com.mytests.test_exam.data.local.dao

import androidx.room.*
import com.mytests.test_exam.data.local.entities.UserEntity

@Dao
interface IUserDao {
    @Insert
    fun insert(user: UserEntity)
    @Delete
    fun delete(user: UserEntity)
    @Query("SELECT * FROM userentity")
    fun getAll(): List<UserEntity>
}