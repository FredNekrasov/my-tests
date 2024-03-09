package com.mytests.testExam.presentation.list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons.Outlined
import androidx.compose.material.icons.outlined.ArrowBackIosNew
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mytests.R.string
import com.mytests.testExam.domain.model.AnimalFacts
import com.mytests.testExam.domain.util.Status
import com.mytests.testExam.presentation.list.view_model.AnimalFactsVM
import com.mytests.ui.customItems.*
import com.mytests.ui.screenRoutes.ExamScreenRoutes

@Composable
fun DataList(controller: NavHostController,viewModel: AnimalFactsVM) {
    val state = viewModel.resultSF.collectAsState().value
    var animalType by rememberSaveable { mutableStateOf("") }
    var amount by rememberSaveable { mutableStateOf("") }
    Box(Modifier.fillMaxSize()) {
        if (state.first == Status.LOADING) CircularProgressIndicator(Modifier.align(Alignment.Center))
        Column(Modifier.fillMaxSize(), Arrangement.Center, Alignment.CenterHorizontally) {
            FredTextHeader(stringResource(string.facts))
            FredTextField(animalType,{ animalType = it }, stringResource(string.enterAnimalType))
            Spacer(Modifier.height(4.dp))
            TextField(
                amount,
                { amount = it },
                placeholder = { Text(stringResource(string.enterAmount),fontFamily = FontFamily.Serif,color = MaterialTheme.colorScheme.onTertiaryContainer) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = OutlinedTextFieldDefaults.colors()
            )
            Spacer(Modifier.height(16.dp))
            Row(Modifier.fillMaxWidth(),Arrangement.SpaceAround,Alignment.CenterVertically) {
                FredIconButton({ controller.navigateUp() },Outlined.ArrowBackIosNew, stringResource(string.goBack))
                this@Box.ShowInternetInfo ({
                    if(animalType.isNotEmpty() && amount.isNotEmpty()) viewModel.getData(animalType,amount.toInt()) else viewModel.getData()
                }, state.first)
                FredIconButton({ controller.navigate(ExamScreenRoutes.Favorites.route) }, Outlined.FavoriteBorder,stringResource(string.favourites))
            }
            Spacer(Modifier.height(16.dp))
            LazyColumn(Modifier.fillMaxSize()) {
                items(state.second) { fact ->
                    var isFavorite by remember { mutableStateOf(fact.isFavorite) }
                    ListItem(fact, isFavorite, { it: AnimalFacts, isFav: Boolean ->
                        viewModel.updateData(it)
                        isFavorite = isFav
                        fact.isFavorite = isFav
                    }, Modifier.fillMaxWidth())
                    Spacer(Modifier.height(16.dp))
                }
            }
        }
    }
}
@Composable
fun BoxScope.ShowInternetInfo(action: () -> Unit,state: Status) {
    val tryAgain = stringResource(string.tryAgain)
    TextButton(
        action,
        Modifier.align(Alignment.BottomCenter),
        enabled = when(state) {
            Status.LOADING -> false
            else -> true
        }
    ) {
        Text(
            when(state) {
                Status.LOADING -> stringResource(string.LOADING)
                Status.SUCCESS -> stringResource(string.SUCCESS)
                Status.NO_DATA -> "${stringResource(string.NO_DATA)}\n${tryAgain}"
                Status.ERROR -> "${stringResource(string.CONNECTION_ERROR)} or ${stringResource(string.NO_INTERNET)}\n${tryAgain}"
                Status.NONE -> "get data"
            },textAlign = TextAlign.Center
        )
    }
}