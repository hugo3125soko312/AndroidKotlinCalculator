package com.example.project2


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculator.MainCalculatorLayout
import com.example.project2.ui.theme.Project2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Project2Theme {
                main2()
            }
        }
    }
}



@Preview(showBackground = true, showSystemUi = true)

@Composable
fun main2() { // MAIN
    MainCalculatorLayout()
    // ihuwdiuhwdihud
}
