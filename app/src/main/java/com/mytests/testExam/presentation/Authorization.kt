package com.mytests.testExam.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mytests.R
import com.mytests.testExam.domain.util.AuthStatus.SUCCESS
import com.mytests.testExam.domain.util.AuthStatus.USER_NOT_FOUND
import com.mytests.testExam.presentation.profile.view_model.UserVM
import com.mytests.testExam.presentation.specialViews.UserNameTF
import com.mytests.ui.customItems.*
import com.mytests.ui.screenRoutes.ExamScreenRoutes

@Composable
fun Authorization(controller: NavController,userVM: UserVM) {
    val userData = userVM.resultSF.collectAsState().value
    var userName by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var isUserNameCorrect by rememberSaveable { mutableStateOf(false) }
    var isPasswordCorrect by rememberSaveable { mutableStateOf(false) }
    Column(Modifier.fillMaxSize(),Arrangement.Center,Alignment.CenterHorizontally) {
        FredTextHeader(stringResource(R.string.authorization))
        Spacer(Modifier.height(64.dp))
        UserNameTF(userName,{ userName = it },isUserNameCorrect)
        Spacer(Modifier.height(8.dp))
        CustomOutlinedTF(
            password,
            { password = it },
            isPasswordCorrect,
            KeyboardType.NumberPassword,
            R.string.enterPassword,
            R.string.incorrectPassword
        )
        Spacer(Modifier.height(32.dp))
        FredButton({
            isUserNameCorrect = userName.isBlank()
            isPasswordCorrect = password.isBlank() || password.length < 8
            if(!isUserNameCorrect && !isPasswordCorrect) userVM.authorization(userName, password)
        },stringResource(R.string.logIn))
        Spacer(Modifier.height(8.dp))
        FredButton({ controller.navigate(ExamScreenRoutes.Registration.route) },stringResource(R.string.registration))
        if(userData.first == SUCCESS) controller.navigate(ExamScreenRoutes.Profile.route)
        if(userData.first == USER_NOT_FOUND) {
            isUserNameCorrect = true
            isPasswordCorrect = true
        }
    }
}