package com.example.jetpackcompose_unitconverter_mvvm

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcompose_unitconverter_mvvm.data.Conversion
import com.example.jetpackcompose_unitconverter_mvvm.data.ConversionResult
import com.example.jetpackcompose_unitconverter_mvvm.data.ConverterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ConverterViewModel(private val converterRepository: ConverterRepository): ViewModel() {

    val selectedConversion : MutableState<Conversion?> = mutableStateOf(null)
    val inputText : MutableState<String> = mutableStateOf("")
    val typedValue: MutableState<String> = mutableStateOf("0.0")

    fun getConversions() = listOf(
        Conversion(id = 1, description = "Pounds to Kilograms", convertFrom = "lbs", convertTo = "kg", multiplyBy = 0.453592),
        Conversion(id = 2, description = "Kilograms to Pounds", convertFrom = "kg", convertTo = "lbs", multiplyBy = 2.2046),
        Conversion(id = 3, description = "Yards to Meters", convertFrom = "yd", convertTo = "m", multiplyBy = 0.9144),
        Conversion(id = 4, description = "Meters to Yards", convertFrom = "m", convertTo = "yd", multiplyBy = 1.09361),
        Conversion(id = 5, description = "Miles to Kilometers", convertFrom = "mi", convertTo = "km", multiplyBy = 1.60934),
        Conversion(id = 6, description = "Kilometers to Miles", convertFrom = "km", convertTo = "mi", multiplyBy = 0.621371)
    )

    val resultList = converterRepository.getAllResults()

    fun addResult(typedValueMessage: String, resultMessage: String){
        viewModelScope.launch(Dispatchers.IO) {
            converterRepository.insertResult(
                ConversionResult(0, typedValueMessage, resultMessage)
            )
        }
    }

    fun deleteResult(item: ConversionResult){
        viewModelScope.launch(Dispatchers.IO) {
            converterRepository.deleteResult(item)
        }
    }

    fun deleteAllResults(){
        viewModelScope.launch(Dispatchers.IO) {
            converterRepository.deleteAllResults()
        }
    }
}