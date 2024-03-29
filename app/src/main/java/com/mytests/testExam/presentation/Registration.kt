package com.mytests.testExam.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mytests.R.string
import com.mytests.testExam.domain.model.User
import com.mytests.testExam.domain.util.AuthStatus.EXISTING_USER
import com.mytests.testExam.domain.util.AuthStatus.SUCCESS
import com.mytests.testExam.presentation.profile.view_model.UserEvent
import com.mytests.testExam.presentation.profile.view_model.UserVM
import com.mytests.testExam.presentation.specialViews.UserNameTF
import com.mytests.ui.customItems.*
import com.mytests.ui.screenRoutes.ExamScreenRoutes

@Composable
fun Registration(controller : NavHostController, userVM : UserVM) {
    val userData = userVM.resultSF.collectAsState().value
    var userName by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var name by rememberSaveable { mutableStateOf("") }
    var surname by rememberSaveable { mutableStateOf("") }

    var isUserNameCorrect by rememberSaveable { mutableStateOf(false) }
    var isPasswordCorrect by rememberSaveable { mutableStateOf(false) }
    var isEmailCorrect by rememberSaveable { mutableStateOf(false) }
    Column(Modifier.fillMaxSize(),Arrangement.Center,Alignment.CenterHorizontally) {
        FredTextHeader(stringResource(string.registration))
        Spacer(Modifier.height(64.dp))
        UserNameTF(userName, { userName = it }, isUserNameCorrect)
        Spacer(Modifier.height(8.dp))
        CustomOutlinedTF(
            password,
            { password = it },
            isPasswordCorrect,
            KeyboardType.NumberPassword,
            string.enterPassword,
            string.incorrectPassword
        )
        Spacer(Modifier.height(8.dp))
        CustomOutlinedTF(
            value = email,
            onValueChange = { email = it },
            isValueCorrect = isEmailCorrect,
            keyboardType = KeyboardType.Email,
            labelId = string.enterEmail,
            errorId = string.incorrectEmail
        )
        Spacer(Modifier.height(8.dp))
        FredTextField(name, { name = it }, stringResource(string.enterName))
        Spacer(Modifier.height(8.dp))
        FredTextField(surname, { surname = it }, stringResource(string.enterSurname))
        Spacer(Modifier.height(32.dp))
        FredButton({
            isUserNameCorrect = userName.isBlank()
            isPasswordCorrect = password.isBlank() || password.length < 8
            isEmailCorrect = email.isBlank() || !email.contains("@")
            if(!isEmailCorrect && !isUserNameCorrect && !isPasswordCorrect) userVM.onUserEvent(UserEvent.Registration(User(userName, password, email, name, surname)))
        },stringResource(string.signUp))
        Spacer(Modifier.height(8.dp))
        FredButton({ controller.navigate(ExamScreenRoutes.Authorization.route) },stringResource(string.goBack))
        Spacer(Modifier.height(8.dp))
        when(userData.status) {
            SUCCESS -> controller.navigate(ExamScreenRoutes.Profile.route)
            EXISTING_USER -> FredText(stringResource(string.existingUser))
            else -> {}
        }
    }
}