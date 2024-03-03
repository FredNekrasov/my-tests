package com.mytests.test_exam.presentation.profile.view_model

import androidx.lifecycle.*
import com.mytests.test_exam.domain.model.User
import com.mytests.test_exam.domain.use_cases.IUserUseCase
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class UserVM(private val userUseCase: IUserUseCase) : ViewModel() {
    private val resultMSF = MutableStateFlow<Pair<Boolean,User?>>(false to null)
    val resultSF = resultMSF.asStateFlow()
    fun authorization(userName: String, password: String) {
        viewModelScope.launch {
            userUseCase.authorization(userName, password).also {
                if(it == null) resultMSF.emit(false to null) else resultMSF.emit(true to it)
            }
        }
    }
    fun registration(user: User) {
        viewModelScope.launch {
            userUseCase.registration(user).also {
                if(it == null) resultMSF.emit(false to null) else resultMSF.emit(true to it)
            }
        }
    }
    fun delete() {
        viewModelScope.launch {
            userUseCase.deleteUser(resultSF.value.second!!)
            resultMSF.emit(false to null)
        }
    }
}