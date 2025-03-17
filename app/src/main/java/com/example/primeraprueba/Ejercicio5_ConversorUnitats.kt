package com.example.primeraprueba

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.primeraprueba.ui.theme.PrimeraPruebaTheme


@Composable
fun Ejercicio5_ConversorUnidades() {
    var valorRecibido by remember { mutableStateOf("") }
    var selectedText by remember { mutableStateOf("") }
    var mensaje by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            "¡Conversor de unidades!",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Red
        )

        TextField(
            value = valorRecibido,
            onValueChange = { valorRecibido = it },
            label = { Text("Introduce el valor que deseas transformar") },
        )

        MyDropDownMenu(selectedText) { selectedText = it }

        Button(onClick = {
            mensaje = Calculos(selectedText, valorRecibido.toDouble())
        }) {
            Text("Calcular")
        }

        if (mensaje.isNotEmpty()) {
            Text(mensaje, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun MyDropDownMenu(selectedText: String, onSelectionChange: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    val cambiosDisponibles = listOf("Polzada-Centímetre", "Iarda-Metre", "Milla-Quilòmetre", "Centímetre-Polzada", "Metre-Iarda", "Quilòmetre-Milla")

    OutlinedTextField(
        value = selectedText,
        onValueChange = { onSelectionChange(it) },
        enabled = false,
        readOnly = true,
        modifier = Modifier
            .clickable { expanded = true }
            .fillMaxWidth()
    )

    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false },
        modifier = Modifier.fillMaxWidth()
    ) {
        cambiosDisponibles.forEach { cambio ->
            DropdownMenuItem(text = { Text(text = cambio) }, onClick = {
                expanded = false
                onSelectionChange(cambio)
            })
        }
    }
}

fun Calculos(selectedText: String, valor: Double): String {
    val resultado = when (selectedText) {
        "Polzada-Centímetre" -> valor * 2.54
        "Iarda-Metre" -> valor * 0.9144
        "Milla-Quilòmetre" -> valor * 1.6
        "Centímetre-Polzada" -> valor / 2.54
        "Metre-Iarda" -> valor * 1.0936
        "Quilòmetre-Milla" -> valor * 0.621371
        else -> return "Selecciona una opción válida."
    }
    return "El resultado es $resultado"
}

