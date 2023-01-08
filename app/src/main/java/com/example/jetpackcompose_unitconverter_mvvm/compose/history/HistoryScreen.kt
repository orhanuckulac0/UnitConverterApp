package com.example.jetpackcompose_unitconverter_mvvm.compose.history

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import com.example.jetpackcompose_unitconverter_mvvm.data.ConversionResult

@Composable
fun HistoryScreen(
    list: State<List<ConversionResult>>,
    modifier: Modifier = Modifier
){
    HistoryList(list = list, onCloseTask = {})
}