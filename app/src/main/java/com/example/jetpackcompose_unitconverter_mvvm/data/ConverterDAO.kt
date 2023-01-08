package com.example.jetpackcompose_unitconverter_mvvm.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ConverterDAO {
    @Insert
    suspend fun insertResult(result: ConversionResult)

    @Delete
    suspend fun deleteResult(result: ConversionResult)

    @Query("DELETE FROM result_table")
    fun deleteAllResults()

    @Query("SELECT * FROM result_table")
    fun getAllResults(): Flow<List<ConversionResult>>
}