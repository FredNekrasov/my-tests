package com.mytests.testExam.data.mappers

import com.mytests.testExam.data.local.entities.UserEntity
import com.mytests.testExam.domain.model.User

fun UserEntity.toDomain() = User(userName, password, email, name, surname, id)
fun User.toEntity() = UserEntity(userName, password, email, name, surname, id)