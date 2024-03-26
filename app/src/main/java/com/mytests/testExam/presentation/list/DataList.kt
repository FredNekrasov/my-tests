package com.mytests.testExam.presentation.list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons.Outlined
import androidx.compose.material.icons.outlined.ArrowBackIosNew
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mytests.R.string
import com.mytests.testExam.domain.model.AnimalFacts
import com.mytests.testExam.domain.util.ConnectionStatus
import com.mytests.testExam.presentation.list.view_model.AnimalFactEvent
import com.mytests.testExam.presentation.list.view_model.AnimalFactsVM
import com.mytests.ui.customItems.*
import com.mytests.ui.screenRoutes.ExamScreenRoutes

@Composable
fun DataList(controller : NavHostController, animalFactsVM : AnimalFactsVM) {
    val state = animalFactsVM.resultSF.collectAsState().value
    var animalType by rememberSaveable { mutableStateOf("") }
    var amount by rememberSaveable { mutableStateOf("") }
    Box(Modifier.fillMaxSize()) {
        if (state.first == ConnectionStatus.LOADING) CircularProgressIndicator(Modifier.align(Alignment.Center))
        Column(Modifier.fillMaxSize(), Arrangement.Center, Alignment.CenterHorizontally) {
            FredTextHeader(stringResource(string.facts))
            FredTextField(animalType,{ animalType = it }, stringResource(string.enterAnimalType))
            Spacer(Modifier.height(4.dp))
            FredTextField(
                amount,
                { if(amount.toIntOrNull() != null && amount.toInt() > 0) amount = it },
                stringResource(string.enterAmount)
            )
            Spacer(Modifier.height(16.dp))
            Row(Modifier.fillMaxWidth(),Arrangement.SpaceAround,Alignment.CenterVertically) {
                FredIconButton({ controller.navigateUp() },Outlined.ArrowBackIosNew, stringResource(string.goBack))
                this@Box.ShowInternetInfo ({
                    animalFactsVM.onEvent(AnimalFactEvent.GetAnimalFacts(animalType,amount.toInt()))
                }, state.first)
                FredIconButton({ controller.navigate(ExamScreenRoutes.Favorites.route) }, Outlined.FavoriteBorder,stringResource(string.favourites))
            }
            Spacer(Modifier.height(16.dp))
            LazyColumn(Modifier.fillMaxSize()) {
                items(state.second) { fact ->
                    var isFavorite by remember { mutableStateOf(fact.isFavorite) }
                    ListItem(fact, isFavorite, { it: AnimalFacts, isFav: Boolean ->
                        isFavorite = isFav
                        fact.isFavorite = isFav
                        animalFactsVM.onEvent(AnimalFactEvent.UpdateAnimalFacts(it))
                    }, Modifier.fillMaxWidth())
                    Spacer(Modifier.height(16.dp))
                }
            }
        }
    }
}
@Composable
fun BoxScope.ShowInternetInfo(action : () -> Unit, state : ConnectionStatus) {
    val tryAgain = stringResource(string.tryAgain)
    TextButton(
        action,
        Modifier.align(Alignment.BottomCenter),
        enabled = when(state) {
            ConnectionStatus.LOADING -> false
            else -> true
        }
    ) {
        Text(
            when(state) {
                ConnectionStatus.LOADING -> stringResource(string.LOADING)
                ConnectionStatus.SUCCESS -> stringResource(string.SUCCESS)
                ConnectionStatus.NO_DATA -> "${stringResource(string.NO_DATA)}\n${tryAgain}"
                ConnectionStatus.ERROR -> "${stringResource(string.CONNECTION_ERROR)} or ${stringResource(string.NO_INTERNET)}\n${tryAgain}"
                ConnectionStatus.NONE -> "get data"
            },textAlign = TextAlign.Center
        )
    }
}