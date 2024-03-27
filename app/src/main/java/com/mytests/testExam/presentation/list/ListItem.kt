package com.mytests.testExam.presentation.list

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mytests.testExam.domain.model.AnimalFacts
import com.mytests.ui.customItems.*

@Composable
fun ListItem(
    fact: AnimalFacts,
    isFavorite: Boolean,
    onUpdate: (AnimalFacts, Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier) {
        FredCardView(Modifier.matchParentSize(), MaterialTheme.colorScheme.primaryContainer, MaterialTheme.colorScheme.onPrimaryContainer)
        Column(Modifier.fillMaxSize().padding(16.dp)) {
            FredText(fact.text, MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            FredText(fact.animalType)
            Spacer(modifier = Modifier.height(8.dp))
            FredCheckbox(isFavorite) { onUpdate(fact, it) }
        }
    }
}