package com.calculadora_imc

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Locale

@Composable
fun PantallaResultado(nombre: String, imc: Double, onVolver: () -> Unit) {

    val (categoria, colorCategoria) = when {
        imc < 18.5 -> Pair("Bajo peso",   Color(0xFFE53935))
        imc < 25.0 -> Pair("Peso normal", Color(0xFF43A047))
        imc < 30.0 -> Pair("Sobrepeso",   Color(0xFFFB8C00))
        else       -> Pair("Obesidad",    Color(0xFFE53935))
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Resultado", fontSize = 26.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(32.dp))

        Text(text = "Hola $nombre, tu resultado es:", fontSize = 18.sp)

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "IMC: ${String.format(Locale.US, "%.1f", imc)}",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = categoria,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            color = colorCategoria
        )

        Spacer(modifier = Modifier.height(48.dp))

        Button(onClick = onVolver, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Volver", fontSize = 16.sp)
        }
    }
}
