package com.mytests.testExam.presentation.list.view_model

import androidx.lifecycle.*
import com.mytests.testExam.domain.model.AnimalFacts
import com.mytests.testExam.domain.useCases.animalFacts.AnimalFactsUseCases
import com.mytests.testExam.domain.util.Status
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.*

class AnimalFactsVM(private val useCases: AnimalFactsUseCases) : ViewModel() {
    private val resultMSF = MutableStateFlow(Status.NONE to emptyList<AnimalFacts>())
    val resultSF = resultMSF.asStateFlow()
    init {
        getData()
    }
    fun getData(animalType: String = "cat",amount: Int = 2) {
        viewModelScope.launch {
            resultMSF.emit(Status.LOADING to emptyList())
            useCases.getFacts.getAnimalFacts(animalType,amount).collectLatest {
                resultMSF.emit(it)
            }
        }
    }
    fun updateData(animalFacts: AnimalFacts) {
        viewModelScope.launch {
            useCases.updateFact.updateFact(animalFacts)
        }
    }
}