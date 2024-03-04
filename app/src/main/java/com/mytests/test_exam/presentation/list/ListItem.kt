package com.mytests.test_exam.presentation.list

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mytests.test_exam.domain.model.AnimalFacts
import com.mytests.ui.customItems.*

@Composable
fun ListItem(fact: AnimalFacts,onUpdate: (AnimalFacts) -> Unit, modifier: Modifier = Modifier) {
    var isFavorite by remember { mutableStateOf(fact.isFavorite) }
    Box(modifier) {
        FredCardView(Modifier.matchParentSize(),MaterialTheme.colorScheme.tertiary,MaterialTheme.colorScheme.onTertiary)
        Column(Modifier.fillMaxSize().padding(16.dp)) {
            FredText(fact.text, MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            FredText(fact.animalType)
            Spacer(modifier = Modifier.height(8.dp))
            FredCheckbox(isFavorite) {
                fact.isFavorite = it
                isFavorite = it
                onUpdate(fact)
            }
        }
    }
}