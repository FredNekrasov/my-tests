package com.mytests.testExam.presentation.list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mytests.R
import com.mytests.testExam.domain.model.AnimalFacts
import com.mytests.testExam.presentation.list.view_model.AnimalFactEvent
import com.mytests.testExam.presentation.list.view_model.AnimalFactsVM
import com.mytests.ui.customItems.*

@Composable
fun FavouriteList(controller : NavHostController, animalFactsVM : AnimalFactsVM) {
    val state = animalFactsVM.resultSF.collectAsState().value
    Box(Modifier.fillMaxSize()) {
        Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(Modifier.height(8.dp))
            FredTextHeader(stringResource(R.string.favourites))
            Spacer(Modifier.height(16.dp))
            LazyColumn(Modifier.fillMaxWidth()) {
                items(state.second) { fact ->
                    if(fact.isFavorite) {
                        var isFavorite by remember { mutableStateOf(fact.isFavorite) }
                        ListItem(fact, isFavorite, { it: AnimalFacts, isFav: Boolean ->
                            isFavorite = isFav
                            fact.isFavorite = isFav
                            animalFactsVM.onEvent(AnimalFactEvent.UpdateAnimalFacts(it))
                        }, Modifier.fillMaxWidth())
                        Spacer(Modifier.height(16.dp))
                    }
                }
                item {
                    Row(Modifier.fillMaxWidth(),Arrangement.Center,Alignment.CenterVertically) {
                        FredButton({ controller.navigateUp() },stringResource(R.string.goBack))
                    }
                    Spacer(Modifier.height(16.dp))
                }
            }
        }
    }
}