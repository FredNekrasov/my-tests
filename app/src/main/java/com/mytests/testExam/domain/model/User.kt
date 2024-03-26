package com.mytests.testExam.domain.model

data class User(
    val userName: String,
    val password: String,
    val email: String,
    val name: String,
    val surname: String,
    val id: Int? = null
)