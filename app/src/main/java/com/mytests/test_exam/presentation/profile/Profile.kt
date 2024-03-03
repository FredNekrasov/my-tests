package com.mytests.test_exam.presentation.profile

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons.Outlined
import androidx.compose.material.icons.outlined.Dataset
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mytests.R.string
import com.mytests.test_exam.presentation.profile.view_model.UserVM
import com.mytests.ui.custom_items.*
import com.mytests.ui.screen_routes.ExamScreenRoutes

@Composable
fun Profile(controller: NavHostController,userVM: UserVM,displayMessage: (String) -> Unit) {
    val user = userVM.resultSF.collectAsState().value.second
    val deleteMessage = stringResource(string.delete)
    Column(Modifier.fillMaxSize(),Arrangement.Top,Alignment.CenterHorizontally) {
        FredTextHeader(stringResource(string.profile))
        Spacer(Modifier.height(16.dp))
        UserInfo(user, {
            userVM.delete()
            controller.popBackStack(ExamScreenRoutes.Authorization.route, false)
            displayMessage(deleteMessage)
        }, Modifier.fillMaxWidth())
        Spacer(Modifier.height(16.dp))
        Row(Modifier.fillMaxWidth(), Arrangement.SpaceAround, Alignment.CenterVertically) {
            FredIconButton({ controller.navigate(ExamScreenRoutes.DataList.route) },Outlined.Dataset, stringResource(string.facts))
            FredIconButton({ controller.navigate(ExamScreenRoutes.Favorites.route) }, Outlined.Favorite, stringResource(string.favourites))
        }
    }
}