package com.example.jetpackcompose_unitconverter_mvvm.compose

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetpackcompose_unitconverter_mvvm.ConverterViewModel
import com.example.jetpackcompose_unitconverter_mvvm.ConverterViewModelFactory
import com.example.jetpackcompose_unitconverter_mvvm.compose.converter.TopScreen
import com.example.jetpackcompose_unitconverter_mvvm.compose.history.HistoryScreen

//Note: Due to their lifecycle and scoping, you should access and call ViewModel instances at screen-level composables,
// that is, close to a root composable called from an activity, fragment, or destination of a Navigation graph.
// You should never pass down ViewModel instances to other composables,
// pass only the data they need and functions that perform the required logic as parameters.

@Composable
fun BaseScreen(
    modifier: Modifier = Modifier,
    factory: ConverterViewModelFactory,
    converterViewModel: ConverterViewModel = viewModel(factory = factory)
){
    val list = converterViewModel.getConversions()
    val historyList = converterViewModel.resultList.collectAsState(initial = emptyList())  // convert flow into state

    val configuration = LocalConfiguration.current
    var isLandscape by remember { mutableStateOf(false) }

    when(configuration.orientation){
        Configuration.ORIENTATION_LANDSCAPE ->{
            isLandscape = true
            Row(modifier = modifier
                .padding(30.dp)
                .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceAround
            ) {
                TopScreen(
                    list,
                    selectedConversion = converterViewModel.selectedConversion,
                    inputText = converterViewModel.inputText,
                    typedValue = converterViewModel.typedValue,
                    save = { typedValueMessage, resultMessage ->
                        converterViewModel.addResult(typedValueMessage, resultMessage) // save to db
                    },
                    isLandscape = isLandscape
                )
                Spacer(modifier = modifier.width(10.dp))
                HistoryScreen(
                    historyList,
                    { item-> converterViewModel.deleteResult(item) },
                    { converterViewModel.deleteAllResults() }
                )
            }
        }
        else ->{
            isLandscape= false
            Column(modifier = modifier.padding(30.dp)) {
                TopScreen(
                    list,
                    selectedConversion = converterViewModel.selectedConversion,
                    inputText = converterViewModel.inputText,
                    typedValue = converterViewModel.typedValue,
                    save = { typedValueMessage, resultMessage ->
                        converterViewModel.addResult(typedValueMessage, resultMessage) // save to db
                    },
                    isLandscape = isLandscape
                )
                Spacer(modifier = modifier.height(20.dp))
                HistoryScreen(
                    historyList,
                    { item-> converterViewModel.deleteResult(item) },
                    { converterViewModel.deleteAllResults() }
                )
            }
        }
    }
}