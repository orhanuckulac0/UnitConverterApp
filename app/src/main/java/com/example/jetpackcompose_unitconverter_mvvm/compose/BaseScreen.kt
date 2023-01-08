package com.example.jetpackcompose_unitconverter_mvvm.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetpackcompose_unitconverter_mvvm.ConverterViewModel

//Note: Due to their lifecycle and scoping, you should access and call ViewModel instances at screen-level composables,
// that is, close to a root composable called from an activity, fragment, or destination of a Navigation graph.
// You should never pass down ViewModel instances to other composables,
// pass only the data they need and functions that perform the required logic as parameters.

@Composable
fun BaseScreen(
    modifier: Modifier = Modifier,
    converterViewModel: ConverterViewModel = viewModel()
){
    val list = converterViewModel.getConversions()
    Column(modifier = modifier.padding(30.dp)) {
        TopScreen(list)
        Spacer(modifier = modifier.height(20.dp))
        HistoryScreen()
    }
}