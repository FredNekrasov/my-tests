package com.mytests.test_exam.domain.model

import com.mytests.test_exam.data.local.entities.AnimalFactsEntity

data class AnimalFacts(
    val text: String,
    val animalType: String,
    var isFavorite: Boolean,
    val id: Int? = null
) {
    fun toEntity() = AnimalFactsEntity(text, animalType, isFavorite, id)
}