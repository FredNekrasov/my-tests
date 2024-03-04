package com.mytests.test_exam.presentation.specialViews

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import com.mytests.R

@Composable
fun UserNameTF(
    userName: String,
    onUserNameChange: (String) -> Unit,
    isUserNameCorrect: Boolean
) {
    TextField(
        userName,
        onUserNameChange,
        label = { Text(stringResource(R.string.enterUN), fontFamily = FontFamily.Serif, color = MaterialTheme.colorScheme.onTertiaryContainer) },
        supportingText = { if(isUserNameCorrect)Text(stringResource(R.string.incorrectUserName), color = MaterialTheme.colorScheme.error, fontFamily = FontFamily.Serif) },
        isError = isUserNameCorrect,
        shape = MaterialTheme.shapes.medium,
        colors = OutlinedTextFieldDefaults.colors()
    )
}