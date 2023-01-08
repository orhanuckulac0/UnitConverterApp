package com.example.jetpackcompose_unitconverter_mvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.jetpackcompose_unitconverter_mvvm.compose.BaseScreen
import com.example.jetpackcompose_unitconverter_mvvm.data.ConverterDatabase
import com.example.jetpackcompose_unitconverter_mvvm.data.ConverterRepositoryImpl
import com.example.jetpackcompose_unitconverter_mvvm.ui.theme.JetpackComposeUnitConverterMVVMTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject lateinit var factory : ConverterViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            JetpackComposeUnitConverterMVVMTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BaseScreen(factory = factory)
                }
            }
        }
    }
}
