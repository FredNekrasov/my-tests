package com.mytests.testExam.presentation.profile

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
import com.mytests.testExam.domain.util.AuthStatus.DELETED
import com.mytests.testExam.presentation.profile.view_model.UserEvent
import com.mytests.testExam.presentation.profile.view_model.UserVM
import com.mytests.ui.customItems.*
import com.mytests.ui.screenRoutes.ExamScreenRoutes

@Composable
fun Profile(controller : NavHostController, userVM : UserVM, displayMessage : (String) -> Unit) {
    val state = userVM.resultSF.collectAsState().value
    val deleteMessage = stringResource(string.delete)
    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(Modifier.height(8.dp))
        FredTextHeader(stringResource(string.profile))
        Spacer(Modifier.height(16.dp))
        UserInfo(state.user, { userVM.onUserEvent(UserEvent.DeleteUser) }, Modifier.fillMaxWidth())
        Spacer(Modifier.height(16.dp))
        Row(Modifier.fillMaxWidth(), Arrangement.SpaceAround, Alignment.CenterVertically) {
            FredIconButton({ controller.navigate(ExamScreenRoutes.DataList.route) }, Outlined.Dataset, stringResource(string.facts))
            FredIconButton({ controller.navigate(ExamScreenRoutes.Favorites.route) }, Outlined.Favorite, stringResource(string.favourites))
        }
        if(state.status == DELETED) {
            controller.popBackStack(ExamScreenRoutes.Authorization.route, false)
            displayMessage(deleteMessage)
        }
    }
}