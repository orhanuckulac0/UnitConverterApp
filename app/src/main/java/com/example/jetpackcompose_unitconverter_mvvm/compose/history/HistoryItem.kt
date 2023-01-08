package com.example.jetpackcompose_unitconverter_mvvm.compose.history

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HistoryItem(
    typedValueMessage: String,
    resultMessage: String,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
){
    Row(modifier = modifier
        .fillMaxWidth()
        .border(border = BorderStroke(0.5.dp, Color.DarkGray)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column() {
            Text(modifier = modifier.padding(5.dp),
                text = typedValueMessage,
                fontSize = 18.sp
            )
            Text(modifier = modifier.padding(5.dp, 0.dp, 0.dp,5.dp),
                text = resultMessage,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Blue
            )
        }
        IconButton(onClick = { onClose() }) {
            Icon(Icons.Filled.Close, contentDescription = "Close")
        }
    }
}