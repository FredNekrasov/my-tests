package com.mytests.testExam.presentation.list.view_model

import androidx.lifecycle.*
import com.mytests.testExam.domain.model.AnimalFacts
import com.mytests.testExam.domain.useCases.animalFacts.AnimalFactsUseCases
import com.mytests.testExam.domain.util.ConnectionStatus
import com.mytests.testExam.presentation.list.view_model.AnimalFactEvent.GetAnimalFacts
import com.mytests.testExam.presentation.list.view_model.AnimalFactEvent.UpdateAnimalFacts
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.*

class AnimalFactsVM(private val useCases: AnimalFactsUseCases) : ViewModel() {
    private val resultMSF = MutableStateFlow(ConnectionStatus.NONE to emptyList<AnimalFacts>())
    val resultSF = resultMSF.asStateFlow()
    init {
        getData()
    }
    fun onEvent(event : AnimalFactEvent) {
        when(event) {
            is GetAnimalFacts -> getData(event.animalType, event.amount)
            is UpdateAnimalFacts -> updateData(event.animalFacts)
        }
    }
    private fun getData(animalType: String = "", amount: Int = 0) {
        viewModelScope.launch {
            useCases.getAnimalFacts(animalType,amount).flowOn(Dispatchers.IO).collectLatest {
                resultMSF.emit(it)
            }
        }
    }
    private fun updateData(animalFacts: AnimalFacts) {
        viewModelScope.launch {
            useCases.updateAnimalFact(animalFacts)
        }
    }
}