package com.mytests.testExam.data.remote.dto


data class AnimalFactsDTO(
    val text: String,
    val type: String,
    val deleted: Boolean,
    val createdAt: String,
    val updatedAt: String
)