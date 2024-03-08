package com.mytests.testExam.domain.repository

import com.mytests.testExam.data.local.entities.UserEntity

interface IUserRepository {
    suspend fun getList(): List<UserEntity>
    suspend fun insert(entity: UserEntity)
    suspend fun delete(entity: UserEntity)
}