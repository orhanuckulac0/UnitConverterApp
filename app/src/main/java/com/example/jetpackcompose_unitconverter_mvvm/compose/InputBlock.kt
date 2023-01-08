package com.example.jetpackcompose_unitconverter_mvvm.compose

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose_unitconverter_mvvm.data.Conversion

@Composable
fun InputBlock(
    conversion: Conversion,
    inputText: MutableState<String>,
    modifier: Modifier = Modifier,
    context: Context = LocalContext.current,
    calculate: (String) -> Unit
){
    Column(modifier = modifier.padding(0.dp, 20.dp, 0.dp, 0.dp)) {
        Row(modifier = modifier.fillMaxWidth()) {
            TextField(
                value = inputText.value,
                onValueChange = {
                    inputText.value = it
                },
                maxLines = 1,
                singleLine = true,
                modifier = modifier.fillMaxWidth(0.65f),
                keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.None,
                autoCorrect = true,
                keyboardType = KeyboardType.Number
                ),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = MaterialTheme.colors.surface.copy(alpha = 0.3f)
                ),
                textStyle = TextStyle(color = Color.DarkGray, fontSize = 20.sp)
            )

            Text(
                text = conversion.convertFrom,
                fontSize = 16.sp,
                modifier = modifier
                    .padding(10.dp, 30.dp, 0.dp, 0.dp)
                    .fillMaxWidth(0.35f)
            )
        }

        Spacer(modifier = modifier.height(20.dp))
        OutlinedButton(onClick = {
            if (inputText.value != "" && !inputText.value.contains(" ")){
                calculate(inputText.value)
            }else{
                Toast.makeText(context, "Please enter a value", Toast.LENGTH_LONG).show()
            }
        },
            modifier = modifier.fillMaxWidth(1F)
        ) {
            Text(
                text = "Convert",
                fontSize = 36.sp,
                fontWeight = FontWeight.Medium,
                color = Color.DarkGray
            )
        }
    }
}