package com.mytests.testExam.domain.repository

import com.mytests.testExam.domain.model.User

interface IUserRepository {
    suspend fun getList(): List<User>
    suspend fun insert(domain: User)
    suspend fun delete(domain: User)
}