package com.example.jetpackcompose_unitconverter_mvvm

import androidx.compose.runtime.Composable

@Composable
fun TopScreen(list: List<Conversion>) {
    ConversionMenu(list = list)
}