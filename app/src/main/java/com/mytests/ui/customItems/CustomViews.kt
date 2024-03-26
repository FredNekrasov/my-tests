package com.mytests.ui.customItems

import androidx.compose.foundation.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.*

@Composable
fun FredCardView(
    modifier: Modifier,
    color1: Color,
    color2: Color,
    cornerRadius: Dp = 10.dp,
    cutCornerSize: Dp = 0.dp
) {
    Canvas(modifier){
        val clipPath = Path().apply {
            lineTo(size.width - cutCornerSize.toPx(), 0f)
            lineTo(size.width, cutCornerSize.toPx())
            lineTo(size.width, size.height)
            lineTo(0f, size.height)
            close()
        }
        clipPath(clipPath){
            drawRoundRect(color = color1, size = size, cornerRadius = CornerRadius(cornerRadius.toPx()))
            drawRoundRect(
                color2,
                Offset(size.width - cutCornerSize.toPx(), -100f),
                Size(cutCornerSize.toPx() + 100f, cutCornerSize.toPx() + 100f),
                CornerRadius(cornerRadius.toPx())
            )
        }
    }
}
@Composable
fun FredTextHeader(value: String, style: TextStyle = MaterialTheme.typography.displayMedium) {
    Text(
        value,
        fontSize = MaterialTheme.typography.displayMedium.fontSize,
        fontFamily = FontFamily.SansSerif,
        style = style,
        color = MaterialTheme.colorScheme.onTertiaryContainer,
        overflow = TextOverflow.Ellipsis
    )
}
@Composable
fun FredText(value: String, style: TextStyle = MaterialTheme.typography.bodyMedium) {
    Text(value, style = style, color = MaterialTheme.colorScheme.onTertiaryContainer, overflow = TextOverflow.Ellipsis)
}
@Composable
fun FredTextField(value: String, onChangeNumber: (String) -> Unit, id: String, modifier: Modifier = Modifier) {
    TextField(
        value,
        onChangeNumber,
        modifier,
        label = { Text(id, fontFamily = FontFamily.Serif, color = MaterialTheme.colorScheme.onTertiaryContainer) },
        shape = MaterialTheme.shapes.medium,
        colors = OutlinedTextFieldDefaults.colors()
    )
}
@Composable
fun FredButton(click: () -> Unit, inf: String, modifier: Modifier = Modifier) {
    OutlinedButton(click, modifier, colors = ButtonDefaults.outlinedButtonColors()) { Text(inf, fontFamily = FontFamily.Serif, color = MaterialTheme.colorScheme.onTertiaryContainer) }
}
@Composable
fun FredCheckbox(value: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Checkbox(
        value,
        onCheckedChange,
        colors = CheckboxDefaults.colors()
    )
}
@Composable
fun FredIconButton(click : () -> Unit, image : ImageVector, description : String, modifier : Modifier = Modifier) {
    IconButton(click, modifier) { Icon(image, description) }
}
@Composable
fun CustomOutlinedTF(
    value: String,
    onValueChange: (String) -> Unit,
    isValueCorrect: Boolean,
    keyboardType: KeyboardType,
    labelId: Int,
    errorId: Int
) {
    OutlinedTextField(
        value,
        onValueChange,
        label = { Text(stringResource(labelId), fontFamily = FontFamily.Serif, color = MaterialTheme.colorScheme.onTertiaryContainer) },
        supportingText = { if(isValueCorrect) Text(stringResource(errorId), color = MaterialTheme.colorScheme.error, fontFamily = FontFamily.Serif) },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        isError = isValueCorrect,
        shape = MaterialTheme.shapes.medium,
        colors = OutlinedTextFieldDefaults.colors()
    )
}