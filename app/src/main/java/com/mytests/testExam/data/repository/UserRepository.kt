package com.mytests.testExam.data.repository

import com.mytests.testExam.data.local.dao.IUserDao
import com.mytests.testExam.data.mappers.toDomain
import com.mytests.testExam.data.mappers.toEntity
import com.mytests.testExam.domain.model.User
import com.mytests.testExam.domain.repository.IUserRepository

class UserRepository(private val dao: IUserDao) : IUserRepository {
    override suspend fun getList(): List<User> = dao.getAll().map { it.toDomain() }
    override suspend fun insert(domain: User) = dao.insert(domain.toEntity())
    override suspend fun delete(domain: User) = dao.delete(domain.toEntity())
}