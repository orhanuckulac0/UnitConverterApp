package com.example.jetpackcompose_unitconverter_mvvm.compose.history

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import com.example.jetpackcompose_unitconverter_mvvm.data.ConversionResult

@Composable
fun HistoryList(
    list: State<List<ConversionResult>>,
    onCloseTask: (ConversionResult) -> Unit,
    modifier: Modifier = Modifier
){
    LazyColumn {
        items(
            items = list.value,
            key = { item-> item.id}
        ){ item->
            HistoryItem(typedValueMessage = item.typedValueMessage, resultMessage = item.resultMessage, onClose = { onCloseTask(item) })
        }
    }
}