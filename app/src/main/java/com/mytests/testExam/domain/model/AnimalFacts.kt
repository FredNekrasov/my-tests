package com.mytests.testExam.domain.model

data class AnimalFacts(
    val text: String,
    val animalType: String,
    var isFavorite: Boolean,
    val id: Int? = null
)