package com.mytests.test_exam.domain.model

import com.mytests.test_exam.data.local.entities.UserEntity

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