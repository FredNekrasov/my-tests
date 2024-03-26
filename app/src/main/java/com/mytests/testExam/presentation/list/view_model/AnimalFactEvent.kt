package com.mytests.testExam.presentation.list.view_model

import com.mytests.testExam.domain.model.AnimalFacts

sealed class AnimalFactEvent {
    data class GetAnimalFacts(val animalType : String, val amount : Int) : AnimalFactEvent()
    data class UpdateAnimalFacts(val animalFacts : AnimalFacts) : AnimalFactEvent()
}