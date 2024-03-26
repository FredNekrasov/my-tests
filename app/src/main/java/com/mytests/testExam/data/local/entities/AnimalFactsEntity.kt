package com.mytests.testExam.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AnimalFactsEntity(
    val text: String,
    val animalType: String,
    val isFavorite: Boolean,
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
)