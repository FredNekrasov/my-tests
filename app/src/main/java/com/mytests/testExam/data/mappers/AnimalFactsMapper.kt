package com.mytests.testExam.data.mappers

import com.mytests.testExam.data.local.entities.AnimalFactsEntity
import com.mytests.testExam.data.remote.dto.AnimalFactsDTO
import com.mytests.testExam.domain.model.AnimalFacts

fun AnimalFactsDTO.toEntity() = AnimalFactsEntity(text, type, false)
fun AnimalFactsEntity.toDomain() = AnimalFacts(text, animalType, isFavorite, id)
fun AnimalFacts.toEntity() = AnimalFactsEntity(text, animalType, isFavorite, id)