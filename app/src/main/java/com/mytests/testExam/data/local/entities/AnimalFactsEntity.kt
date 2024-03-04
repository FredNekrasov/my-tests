package com.mytests.testExam.data.local.entities

import androidx.room.*
import com.mytests.testExam.domain.model.AnimalFacts

@Entity
data class AnimalFactsEntity(
    val text: String,
    val animalType: String,
    val isFavorite: Boolean,
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
) {
    fun toDomain() = AnimalFacts(text, animalType, isFavorite, id)
}