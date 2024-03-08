package com.mytests.testExam.data.repository

import com.mytests.testExam.data.local.dao.IUserDao
import com.mytests.testExam.data.local.entities.UserEntity
import com.mytests.testExam.domain.repository.IUserRepository

class UserRepository(private val dao: IUserDao) : IUserRepository {
    override suspend fun getList(): List<UserEntity> = dao.getAll()
    override suspend fun insert(entity: UserEntity) = dao.insert(entity)
    override suspend fun delete(entity: UserEntity) = dao.delete(entity)
}