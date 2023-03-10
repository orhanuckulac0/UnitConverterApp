package com.example.jetpackcompose_unitconverter_mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackcompose_unitconverter_mvvm.data.ConverterRepository
import javax.inject.Inject

class ConverterViewModelFactory @Inject constructor(
    private val converterRepository: ConverterRepository
    ): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ConverterViewModel(converterRepository) as T
    }
}
