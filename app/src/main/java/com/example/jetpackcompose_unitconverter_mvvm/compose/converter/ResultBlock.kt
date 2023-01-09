package com.example.jetpackcompose_unitconverter_mvvm.compose.converter

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ResultBlock(
    typedValueMessage: String,
    resultMessage: String,
    isLandscape: Boolean,
    modifier: Modifier = Modifier
){
    if (isLandscape){
        Card(
            elevation = 20.dp,
            modifier = modifier
                .padding(0.dp, 20.dp, 0.dp, 0.dp)
                .fillMaxWidth(0.4f),
            ) {
            Column(
                modifier = modifier.padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = typedValueMessage,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center
                )

                Text(
                    text = resultMessage,
                    fontSize = 24.sp,
                    color = Color.DarkGray,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center
                )
            }
        }
    }else{
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Card(
                elevation = 20.dp,
                modifier = modifier
                    .padding(0.dp, 20.dp, 0.dp, 10.dp)
                    .fillMaxWidth(),
            ) {
                Column(
                    modifier = modifier.padding(10.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = typedValueMessage,
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center
                    )

                    Text(
                        text = resultMessage,
                        fontSize = 24.sp,
                        color = MaterialTheme.colors.primary,
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}