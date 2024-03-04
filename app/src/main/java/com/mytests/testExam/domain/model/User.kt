package com.mytests.testExam.domain.model

import com.mytests.testExam.data.local.entities.UserEntity

data class User(
    val userName: String,
    val password: String,
    val email: String,
    val name: String,
    val surname: String,
    val id: Int? = null
) {
    fun toEntity() = UserEntity(userName, password, email, name, surname, id)
}