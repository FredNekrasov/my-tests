package com.mytests.test_exam.presentation.list.view_model

import androidx.lifecycle.*
import com.mytests.test_exam.domain.model.AnimalFacts
import com.mytests.test_exam.domain.use_cases.IAnimalFactsUseCase
import com.mytests.test_exam.domain.util.Status
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.*

class AnimalFactsVM(private val animalFactsUseCase: IAnimalFactsUseCase) : ViewModel() {
    private val resultMSF = MutableStateFlow(Status.NONE to emptyList<AnimalFacts>())
    val resultSF = resultMSF.asStateFlow()
    init {
        getData("cat",5)
    }
    fun getData(animalType: String,amount: Int) {
        viewModelScope.launch {
            resultMSF.emit(Status.LOADING to emptyList())
            animalFactsUseCase.getAnimalFacts(animalType,amount).collectLatest {
                resultMSF.emit(it)
            }
        }
    }
}