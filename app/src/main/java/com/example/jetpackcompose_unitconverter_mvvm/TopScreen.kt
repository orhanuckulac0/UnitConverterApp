package com.example.jetpackcompose_unitconverter_mvvm

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun TopScreen(list: List<Conversion>) {

    val selectedConversion : MutableState<Conversion?> = remember {
        mutableStateOf(null)
    }

    val inputText : MutableState<String> = remember {
        mutableStateOf("")
    }

    ConversionMenu(list = list){
        selectedConversion.value = it
    }

    selectedConversion.value?.let {
        InputBlock(conversion = it, inputText = inputText){ input->
            Log.i("MYTAG", "User typed $input")
        }
    }
}