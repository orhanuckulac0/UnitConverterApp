package com.example.jetpackcompose_unitconverter_mvvm.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "result_table")
data class ConversionResult(
    @PrimaryKey(autoGenerate = true)

    @ColumnInfo(name = "result_id")
    val id: Int,

    @ColumnInfo(name = "result_typed_value_message")
    val typedValueMessage: String,

    @ColumnInfo(name = "result_message")
    val resultMessage: String
)