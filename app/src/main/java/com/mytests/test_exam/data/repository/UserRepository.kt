package com.mytests.test_exam.data.repository

import com.mytests.test_exam.data.local.dao.IUserDao
import com.mytests.test_exam.data.local.entities.UserEntity
import com.mytests.test_exam.domain.repository.IUserRepository

class UserRepository(private val dao: IUserDao) : IUserRepository {
    override fun getList(): List<UserEntity> = dao.getAll()
    override fun insert(entity: UserEntity) = dao.insert(entity)
    override fun delete(entity: UserEntity) = dao.delete(entity)
}