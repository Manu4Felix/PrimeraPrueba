package com.example.primeraprueba

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun Ejercicio3_AdivinaNumeroSecreto() {
    var numeroBuscado by remember { mutableStateOf((0..100).random()) }
    var numeroRecibido by remember { mutableStateOf("") }
    var mensaje by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Endevina el número secret!", fontSize = 20.sp, fontWeight = FontWeight.Bold)

        TextField(
            value = numeroRecibido,
            onValueChange = { numeroRecibido = it },
            label = { Text("Introduce un número del 1 al 100.") },
        )

        Button(onClick = {
            val numero = numeroRecibido.toIntOrNull()
            mensaje = when {
                numero == null -> "Introduce un número válido."
                numero > numeroBuscado -> "El número que buscas es más pequeño."
                numero < numeroBuscado -> "El número que buscas es más grande."
                else -> "Has acertado! Enhorabuena."
            }
        }) {
            Text("Comprobar número")
        }

        if (mensaje.isNotEmpty()) {
            Text(mensaje, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
    }
}

