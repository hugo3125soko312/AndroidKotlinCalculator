package com.example.calculator

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorButton(
    label: String,
    color: Color = Color.LightGray,
    fontSize: Int = 20,
    visibleCurrentText: MutableState<String>
) {

    
    Button(
        onClick = {
            Log.i("BUTTON", "$label pressed")
            if (label == "DEL") {
                if (visibleCurrentText.value.isNotEmpty()) {
                    val stringed = StringBuilder(visibleCurrentText.value)
                    stringed.deleteAt(stringed.length - 1)
                    visibleCurrentText.value = stringed.toString()
                }
            } else {
                visibleCurrentText.value += label // update value
            }
        },
        shape = ButtonDefaults.shape, // shape parameter placed correctly
        modifier = Modifier
            .padding(4.dp)
            .size(64.dp),
        colors = ButtonDefaults.buttonColors(containerColor = color)
    ) { Text(text = label, fontSize = fontSize.sp) }

}

@Composable
fun CalculatorLayout() {
    val visibleCurrentText = remember { mutableStateOf("github.com/hugo3125soko312") } // Use remember to store the state

    val buttonColor = Color(0xFFE0E0E0) //numbers
    val operatorColor = Color(0xFFFFA726) // operands

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp), // padding between all buttons and text; 20 default
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Display (placeholder)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(450.dp)
                .padding(8.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = visibleCurrentText.value, // Use value to access the state
                style = MaterialTheme.typography.headlineLarge,
                color = Color.Black
            )
        }

        // Buttons
        Column {
            // clear delete /TODO: make wider buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                CalculatorButton("C", operatorColor, visibleCurrentText = visibleCurrentText)
                CalculatorButton("8", operatorColor, visibleCurrentText = visibleCurrentText)
                CalculatorButton("9", operatorColor, visibleCurrentText = visibleCurrentText)
                CalculatorButton("DEL", operatorColor, visibleCurrentText = visibleCurrentText)
            }
            // ROW 7 8 9 /
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                CalculatorButton("7", buttonColor, visibleCurrentText = visibleCurrentText)
                CalculatorButton("8", buttonColor, visibleCurrentText = visibleCurrentText)
                CalculatorButton("9", buttonColor, visibleCurrentText = visibleCurrentText)
                CalculatorButton("÷", operatorColor, visibleCurrentText = visibleCurrentText)
            }
            // ROW 4 5 6 *
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                CalculatorButton("4", buttonColor, visibleCurrentText = visibleCurrentText)
                CalculatorButton("5", buttonColor, visibleCurrentText = visibleCurrentText)
                CalculatorButton("6", buttonColor, visibleCurrentText = visibleCurrentText)
                CalculatorButton("×", operatorColor, visibleCurrentText = visibleCurrentText)
            }
            // ROW 1 2 3 -
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                CalculatorButton("1", buttonColor, visibleCurrentText = visibleCurrentText)
                CalculatorButton("2", buttonColor, visibleCurrentText = visibleCurrentText)
                CalculatorButton("3", buttonColor, visibleCurrentText = visibleCurrentText)
                CalculatorButton("-", operatorColor, visibleCurrentText = visibleCurrentText)
            }
            // ROW  0 . = +
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                CalculatorButton("0", buttonColor, visibleCurrentText = visibleCurrentText)
                CalculatorButton(".", buttonColor, visibleCurrentText = visibleCurrentText)
                CalculatorButton("=", operatorColor, visibleCurrentText = visibleCurrentText)
                CalculatorButton("+", operatorColor, visibleCurrentText = visibleCurrentText)
            }
        }
    }
}

// FOR PREVIEWS IGGERS
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainCalculatorLayout(){
    CalculatorLayout()
}
