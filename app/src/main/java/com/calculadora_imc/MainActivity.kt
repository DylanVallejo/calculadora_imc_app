package com.calculadora_imc

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.calculadora_imc.ui.theme.Calculadora_imcTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Calculadora_imcTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppNavigation(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "ingreso",
        modifier = modifier
    ) {

        composable("ingreso") {
            PantallaIngreso(onCalcular = { nombre, imc ->
                val nombreEncoded = Uri.encode(nombre)
                navController.navigate("resultado/$nombreEncoded/$imc")
            })
        }

        // Ruta con dos parámetros: nombre e imc
        composable(
            route = "resultado/{nombre}/{imc}",
            arguments = listOf(
                navArgument("nombre") { type = NavType.StringType },
                navArgument("imc")    { type = NavType.FloatType }
            )
        ) { backStackEntry ->
            val nombre = backStackEntry.arguments?.getString("nombre") ?: ""
            val imc    = backStackEntry.arguments?.getFloat("imc")?.toDouble() ?: 0.0

            PantallaResultado(
                nombre = nombre,
                imc = imc,
                onVolver = { navController.popBackStack() }
            )
        }
    }
}
