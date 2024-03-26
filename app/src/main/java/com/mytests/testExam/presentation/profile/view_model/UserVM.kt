package com.mytests.testExam.presentation.profile.view_model

import androidx.lifecycle.*
import com.mytests.testExam.domain.model.User
import com.mytests.testExam.domain.useCases.user.UserUseCases
import com.mytests.testExam.domain.util.UserData
import com.mytests.testExam.presentation.profile.view_model.UserEvent.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class UserVM(private val useCases: UserUseCases) : ViewModel() {
    private val resultMSF = MutableStateFlow<UserData>(UserData.EmptyUser)
    val resultSF = resultMSF.asStateFlow()
    fun onUserEvent(event : UserEvent) {
        when(event) {
            is Authorization -> authorization(event.login, event.password)
            DeleteUser -> delete()
            is Registration -> registration(event.user)
        }
    }
    private fun authorization(userName: String, password: String) {
        viewModelScope.launch {
            useCases.authorizationUseCase.authorization(userName,password).also { resultMSF.emit(it) }
        }
    }
    private fun registration(user: User) {
        viewModelScope.launch {
            useCases.registrationUseCase.registration(user).also { resultMSF.emit(it) }
        }
    }
    private fun delete() {
        viewModelScope.launch {
            useCases.deleteUserUseCase.deleteUser(resultSF.value.user).also { resultMSF.emit(it) }
        }
    }
}