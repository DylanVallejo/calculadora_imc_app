package com.calculadora_imc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.calculadora_imc.ui.theme.Calculadora_imcTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Calculadora_imcTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    PantallaIngreso(onCalcular = { _, _, _ -> })
                }
            }
        }
    }
}
