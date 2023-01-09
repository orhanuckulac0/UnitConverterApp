package com.example.jetpackcompose_unitconverter_mvvm.compose.converter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.jetpackcompose_unitconverter_mvvm.data.Conversion
import java.math.RoundingMode
import java.text.DecimalFormat


@Composable
fun TopScreen(
    list: List<Conversion>,
    save: (String, String) -> Unit,
    selectedConversion: MutableState<Conversion?>,
    inputText: MutableState<String>,
    typedValue: MutableState<String>,
    isLandscape: Boolean,
) {

    var toSave by remember {
        mutableStateOf(false)
    }

    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        ConversionMenu(list = list, isLandscape = isLandscape){
            selectedConversion.value = it
            typedValue.value = "0.0"
        }

        selectedConversion.value?.let {
            InputBlock(
                conversion = it,
                inputText = inputText,
                isLandscape = isLandscape,
                calculate = { input->
                    typedValue.value = input
                    inputText.value = ""
                    toSave = true
                }
            )
        }

        if (typedValue.value != "0.0"){
            val input = typedValue.value.toDouble()
            val multiplyRatio = selectedConversion.value!!.multiplyBy
            val result = input * multiplyRatio

            // define pattern for 4 decimal places
            val df = DecimalFormat("#.####")
            df.roundingMode = RoundingMode.DOWN
            val roundedResult = df.format(result)

            val typedValueMessage = "${typedValue.value} ${selectedConversion.value!!.convertFrom} is equal to"
            val resultMessage = "$roundedResult ${selectedConversion.value!!.convertTo}"

            if (toSave){
                save(typedValueMessage, resultMessage)
                toSave = false
            }

            ResultBlock(
                typedValueMessage = typedValueMessage,
                resultMessage = resultMessage,
                isLandscape = isLandscape
            )
        }
    }
}