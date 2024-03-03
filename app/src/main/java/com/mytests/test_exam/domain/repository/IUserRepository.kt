package com.mytests.test_exam.domain.repository

import com.mytests.test_exam.data.local.entities.UserEntity

interface IUserRepository {
    fun getList(): List<UserEntity>
    fun insert(entity: UserEntity)
    fun delete(entity: UserEntity)
}