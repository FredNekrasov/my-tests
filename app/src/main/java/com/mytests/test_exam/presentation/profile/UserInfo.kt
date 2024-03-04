package com.mytests.test_exam.presentation.profile

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mytests.R.string
import com.mytests.test_exam.domain.model.User
import com.mytests.ui.customItems.FredCardView

@Composable
fun UserInfo(user: User?, onDeleteClick: () -> Unit, modifier: Modifier) {
    if (user != null) {
        Box(modifier) {
            FredCardView(Modifier.matchParentSize(),MaterialTheme.colorScheme.onSecondaryContainer,MaterialTheme.colorScheme.secondaryContainer)
            Column(modifier.padding(16.dp).padding(end = 32.dp)) {
                Text("${stringResource(string.userName)}: ${user.userName}", style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.secondaryContainer)
                Spacer(Modifier.height(8.dp))
                Text("${stringResource(string.password)}: ${user.password}", style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.secondaryContainer)
                Spacer(Modifier.height(8.dp))
                Text("${stringResource(string.email)}: ${user.email}", style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.secondaryContainer)
                Spacer(Modifier.height(8.dp))
                Text("${stringResource(string.name)}: ${user.name}", style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.secondaryContainer)
                Spacer(Modifier.height(8.dp))
                Text("${stringResource(string.surname)}: ${user.surname}", style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.secondaryContainer)
                Spacer(Modifier.height(8.dp))
            }
            IconButton(onDeleteClick, Modifier.align(Alignment.BottomEnd)) { Icon(Icons.Default.Delete,stringResource(string.delete), tint = MaterialTheme.colorScheme.secondaryContainer) }
        }
    }
}