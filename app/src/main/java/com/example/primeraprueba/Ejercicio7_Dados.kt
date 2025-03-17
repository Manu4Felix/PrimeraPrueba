package com.example.primeraprueba

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.primeraprueba.ui.theme.PrimeraPruebaTheme
import kotlin.random.Random


@Composable
fun Ejercicio7_Dados() {
    var dado1: Int by remember { mutableIntStateOf(1) }
    var dado2: Int by remember { mutableIntStateOf(1) }
    var imagenDado1: Int by remember { mutableIntStateOf(R.drawable.dice_1) }
    var imagenDado2: Int by remember { mutableIntStateOf(R.drawable.dice_1) }
    var context = LocalContext.current

    // Insertamos el fondo
    Image(
        painter = painterResource(id = R.drawable.tapestry),
        contentDescription = "Fondo",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )

    Column(
        Modifier
            .fillMaxSize()
            .padding(top = 55.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        Image(
            painter = painterResource(id = R.drawable.title),
            contentDescription = "Logo",
            modifier = Modifier.size(400.dp)
        )

        Button(
            onClick = {
                dado1 = NumeroAleatorioDado()
                dado2 = NumeroAleatorioDado()

                imagenDado1 = DadoRandom(dado1)
                imagenDado2 = DadoRandom(dado2)

                if (dado1 == 6 && dado2 == 6) {
                    Toast.makeText(context, "¡JACKPOT!", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.fillMaxWidth(0.9f),
            colors = buttonColors(containerColor = Color.Red)
        ) {
            Text(text = "Roll the dice", fontSize = 24.sp, color = Color.White)
        }

        Spacer(Modifier.fillMaxHeight(0.05f))

        // Definimos los dados
        Row {
            Image(
                painter = painterResource(id = imagenDado1),
                contentDescription = "Dado 1",
                modifier = Modifier.size(230.dp).clickable {
                    dado1 = NumeroAleatorioDado()
                    imagenDado1 = DadoRandom(dado1)
                }
            )

            Image(
                painter = painterResource(id = imagenDado2),
                contentDescription = "Dado 2",
                modifier = Modifier.size(230.dp).clickable {
                    dado2 = NumeroAleatorioDado()
                    imagenDado2 = DadoRandom(dado2)
                }
            )
        }
    }
}

fun NumeroAleatorioDado(): Int {
    return Random.nextInt(1, 7)
}

fun DadoRandom(dado: Int): Int {
    return when (dado) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Pruebas() {
    PrimeraPruebaTheme {
        Ejercicio7_Dados()
    }
}