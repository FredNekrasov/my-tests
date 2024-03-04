package com.mytests.testExam.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.navigation.compose.*
import com.mytests.testExam.presentation.list.DataList
import com.mytests.testExam.presentation.list.FavouriteList
import com.mytests.testExam.presentation.list.view_model.AnimalFactsVM
import com.mytests.testExam.presentation.profile.Profile
import com.mytests.testExam.presentation.profile.view_model.UserVM
import com.mytests.ui.screenRoutes.ExamScreenRoutes
import org.koin.androidx.compose.koinViewModel

@Composable
fun ExamScaffold(displayMessage: (String) -> Unit) {
    val controller = rememberNavController()
    val viewModel: AnimalFactsVM = koinViewModel()
    val userVM: UserVM = koinViewModel()
    Column(Modifier.fillMaxSize(),Arrangement.Center,Alignment.CenterHorizontally) {
        NavHost(controller, startDestination = ExamScreenRoutes.Authorization.route) {
            composable(ExamScreenRoutes.Authorization.route) { Authorization(controller,userVM) }
            composable(ExamScreenRoutes.Registration.route) { Registration(controller,userVM) }
            composable(ExamScreenRoutes.Profile.route) { Profile(controller,userVM,displayMessage) }
            composable(ExamScreenRoutes.DataList.route) { DataList(controller,viewModel) }
            composable(ExamScreenRoutes.Favorites.route) { FavouriteList(controller,viewModel) }
        }
    }
}