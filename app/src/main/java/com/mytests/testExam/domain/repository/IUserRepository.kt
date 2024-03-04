package com.mytests.testExam.domain.repository

import com.mytests.testExam.data.local.entities.UserEntity

interface IUserRepository {
    fun getList(): List<UserEntity>
    fun insert(entity: UserEntity)
    fun delete(entity: UserEntity)
}