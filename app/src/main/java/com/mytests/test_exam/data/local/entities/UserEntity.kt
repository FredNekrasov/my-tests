package com.mytests.test_exam.data.local.entities

import androidx.room.*
import com.mytests.test_exam.domain.model.User

@Entity
data class UserEntity(
    val userName: String,
    val password: String,
    val email: String,
    val name: String,
    val surname: String,
    @PrimaryKey(autoGenerate = true) val id: Int? = null
) {
    fun toDomain() = User(userName, password, email, name, surname)
}