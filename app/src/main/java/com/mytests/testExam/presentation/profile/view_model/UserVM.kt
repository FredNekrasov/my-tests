package com.mytests.testExam.presentation.profile.view_model

import androidx.lifecycle.*
import com.mytests.testExam.domain.model.User
import com.mytests.testExam.domain.useCases.IUserUseCase
import com.mytests.testExam.domain.util.AuthStatus
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class UserVM(private val userUseCase: IUserUseCase) : ViewModel() {
    private val resultMSF = MutableStateFlow<Pair<AuthStatus,User?>>(AuthStatus.EMPTY_USER to null)
    val resultSF = resultMSF.asStateFlow()
    fun authorization(userName: String, password: String) {
        viewModelScope.launch {
            userUseCase.authorization(userName, password).also {
                if(it == null) resultMSF.emit(AuthStatus.USER_NOT_FOUND to null) else resultMSF.emit(AuthStatus.SUCCESS to it)
            }
        }
    }
    fun registration(user: User) {
        viewModelScope.launch {
            userUseCase.registration(user).also {
                if(it == null) resultMSF.emit(AuthStatus.EXISTING_USER to null) else resultMSF.emit(AuthStatus.SUCCESS to it)
            }
        }
    }
    fun delete() {
        viewModelScope.launch {
            userUseCase.deleteUser(resultSF.value.second!!)
            resultMSF.emit(AuthStatus.DELETED to null)
        }
    }
}