package com.mytests.testExam.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(
    val userName: String,
    val password: String,
    val email: String,
    val name: String,
    val surname: String,
    @PrimaryKey(autoGenerate = true) val id: Int? = null
)