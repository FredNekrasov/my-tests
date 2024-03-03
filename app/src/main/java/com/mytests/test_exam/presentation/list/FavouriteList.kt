package com.mytests.test_exam.presentation.list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mytests.R
import com.mytests.test_exam.presentation.list.view_model.AnimalFactsVM
import com.mytests.ui.custom_items.*

@Composable
fun FavouriteList(controller: NavHostController,viewModel: AnimalFactsVM) {
    val state = viewModel.resultSF.collectAsState().value
    Box(Modifier.fillMaxSize()) {
        Column(Modifier.fillMaxSize(), Arrangement.Center, Alignment.CenterHorizontally) {
            FredTextHeader(stringResource(R.string.favourites))
            Spacer(Modifier.height(16.dp))
            LazyColumn(Modifier.fillMaxWidth()) {
                items(state.second) { fact ->
                    if(fact.isFavorite) {
                        ListItem(fact,Modifier.fillMaxWidth())
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