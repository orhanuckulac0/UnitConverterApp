package com.example.jetpackcompose_unitconverter_mvvm.data

import kotlinx.coroutines.flow.Flow

class ConverterRepositoryImpl(private val converterDAO: ConverterDAO): ConverterRepository {
    override suspend fun insertResult(result: ConversionResult) {
        converterDAO.insertResult(result)
    }

    override suspend fun deleteResult(result: ConversionResult) {
        converterDAO.deleteResult(result)
    }

    override suspend fun deleteAllResults() {
        converterDAO.deleteAllResults()
    }

    override fun getAllResults(): Flow<List<ConversionResult>> {
        return converterDAO.getAllResults()
    }
}