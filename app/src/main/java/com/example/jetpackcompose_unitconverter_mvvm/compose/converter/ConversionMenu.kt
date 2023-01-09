package com.example.jetpackcompose_unitconverter_mvvm.compose.converter

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.example.jetpackcompose_unitconverter_mvvm.data.Conversion

@Composable
fun ConversionMenu(
    list: List<Conversion>,
    modifier: Modifier = Modifier,
    convert: (Conversion)-> Unit
){
    var displayText by rememberSaveable { mutableStateOf("Select the conversion type") }

    // to assign the dropdown menu the same width as TextField
    var textFieldSize by remember { mutableStateOf(Size.Zero) }

    // for displaying icon of the dropdown menu
    var expanded by remember { mutableStateOf(false) }

    val icon = if (expanded){
        Icons.Filled.KeyboardArrowUp
    }else{
        Icons.Filled.KeyboardArrowDown
    }

    Column {
        OutlinedTextField(
            value = displayText,
            onValueChange = { displayText = it },
            textStyle = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
            modifier = modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    textFieldSize = coordinates.size.toSize()
                }
                .clickable { expanded = !expanded }
            ,
            label = { Text(text = "Conversion type")},
            trailingIcon = {
                Icon(
                    icon, contentDescription = "icon",
                    modifier.clickable { expanded = !expanded }
                )},
            readOnly = true,
            // disable textfield to make it clickable
            enabled = false,
            // apply enabled OutlinedTextField default colors
            colors = TextFieldDefaults.outlinedTextFieldColors(
                disabledTextColor = LocalContentColor.current.copy(LocalContentAlpha.current),
                backgroundColor = Color.Transparent,
                disabledBorderColor = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.disabled),
                disabledLabelColor = MaterialTheme.colors.onSurface.copy(ContentAlpha.medium),
            )
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded=false },
            modifier = modifier.width(with(LocalDensity.current) {textFieldSize.width.toDp()})
        ) {
            list.forEach { conversion ->
                DropdownMenuItem(
                    onClick = {
                        displayText = conversion.description
                        expanded=false
                        convert(conversion)
                    }) {
                    Text(
                        text = conversion.description,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}