package com.example.jetpackcompose_unitconverter_mvvm.data

import kotlinx.coroutines.flow.Flow


interface ConverterRepository {

    suspend fun insertResult(result: ConversionResult)
    suspend fun deleteResult(result: ConversionResult)
    suspend fun deleteAllResults()
    fun getAllResults(): Flow<List<ConversionResult>>

}