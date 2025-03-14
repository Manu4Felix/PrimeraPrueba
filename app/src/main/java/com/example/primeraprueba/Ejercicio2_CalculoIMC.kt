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

@Composable
fun Ejercicio2_CalculoIMC() {
    var nombre: String by remember { mutableStateOf("") }
    var anyNacimiento: String by remember { mutableStateOf("") }
    var altura: String by remember { mutableStateOf("") }
    var peso: String by remember { mutableStateOf("") }
    var showText: Boolean by remember { mutableStateOf(false) }
    var edad: Int by remember { mutableIntStateOf(0) }
    var imc: Double by remember { mutableDoubleStateOf(0.0) }

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") }
        )

        TextField(
            value = anyNacimiento,
            onValueChange = { anyNacimiento = it },
            label = { Text("Año de nacimiento") }
        )

        TextField(
            value = altura,
            onValueChange = { altura = it },
            label = { Text("Altura") }
        )

        TextField(
            value = peso,
            onValueChange = { peso = it },
            label = { Text("Peso") }
        )

        Button(onClick = {
            showText = true
            edad = 2025 - anyNacimiento.toInt()
            imc = peso.toDouble() / (altura.toDouble()*2)

        }) {
            Text("Calcular IMC")
        }

        if (showText) {
            Text("La propina es: $nombre")
            Text("El precio total a pagar es: $edad")
            if (imc < 18.5){
                Text("Peso insuficiente...")
            }
            else if (imc>18.5 && imc<24.5){
                Text("¡Peso normal!")
            }
            else if (imc>25.0 && imc<50.0){
                Text("Sobrepeso")
            }
            else{
                Text("Obesidad")
            }
        }
    }
}

