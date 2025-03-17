package com.example.primeraprueba

import Ejercicio1_CalculaPropina
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.collection.intIntMapOf
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.primeraprueba.ui.theme.PrimeraPruebaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PrimeraPruebaTheme {
                Ejercicio7_Dados()
            }
        }
    }
}

@Composable
fun Body() {
    var name: String by remember { mutableStateOf("") }
    var showText: Boolean by remember { mutableStateOf(false) }
    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        TextField(value = name, onValueChange = { name = it }, label = { Text("Introduce tu nombre") })
        Button(onClick = {showText = true}) {
            Text("Iniciar Sesión")
        }
        Spacer(Modifier.fillMaxHeight(0.1f))
        if (showText) {
            Text("Hola $name", fontWeight = FontWeight.Bold, fontSize = 24.sp)

        }
    }
}

@Composable
fun Ejercicio3(modifier: Modifier) {

    Column(modifier.fillMaxSize()) {
        Row(
            modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Column(
                modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .background(Color(0xFFEADDFF)),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    "Text composable",
                    textAlign = TextAlign.Center,
                    modifier = modifier.fillMaxWidth(),
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier.height(12.dp))
                Text(
                    "Displays text and follows the recommended Material Design guidelines",
                    textAlign = TextAlign.Justify,
                    modifier = modifier.padding(8.dp)
                )

            }
            Column(
                modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .background(Color(0xFFD0BCFF)),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    "Text composable",
                    textAlign = TextAlign.Center,
                    modifier = modifier.fillMaxWidth(),
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier.height(12.dp))
                Text(
                    "Displays text and follows the recommended Material Design guidelines",
                    textAlign = TextAlign.Justify,
                    modifier = modifier.padding(8.dp)
                )

            }

        }
        Row(
            modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Column(
                modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .background(Color(0xFFB69DF8)),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    "Text composable",
                    textAlign = TextAlign.Center,
                    modifier = modifier.fillMaxWidth(),
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier.height(12.dp))
                Text(
                    "Displays text and follows the recommended Material Design guidelines",
                    textAlign = TextAlign.Justify,
                    modifier = modifier.padding(8.dp)
                )

            }
            Column(
                modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .background(Color(0xFFF6EDFF)),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    "Text composable",
                    textAlign = TextAlign.Center,
                    modifier = modifier.fillMaxWidth(),
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier.height(12.dp))
                Text(
                    "Displays text and follows the recommended Material Design guidelines",
                    textAlign = TextAlign.Justify,
                    modifier = modifier.padding(8.dp)
                )

            }

        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {

    ConstraintLayout(modifier.fillMaxSize()) {
        val (boxRed, boxYellow, boxGreen, boxCyan, boxMagenta) = createRefs()
        Box(
            modifier = Modifier
                .size(120.dp)
                .background(Color.Red)
                .constrainAs(boxRed) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                })
        Box(
            modifier = Modifier
                .size(120.dp)
                .background(Color.Yellow)
                .constrainAs(boxYellow) {
                    start.linkTo(boxRed.start)
                    bottom.linkTo(boxRed.top)
                })
        Box(
            modifier = Modifier
                .size(120.dp)
                .background(Color.Green)
                .constrainAs(boxGreen) {
                    start.linkTo(boxRed.start)
                    top.linkTo(boxRed.bottom)
                })
        Box(
            modifier = Modifier
                .size(120.dp)
                .background(Color.Cyan)
                .constrainAs(boxCyan) {
                    end.linkTo(boxRed.start)
                    top.linkTo(boxRed.top)
                })
        Box(
            modifier = Modifier
                .size(120.dp)
                .background(Color.Magenta)
                .constrainAs(boxMagenta) {
                    start.linkTo(boxRed.end)
                    top.linkTo(boxRed.top)
                })
    }
    Image(
        painter = painterResource(id = R.drawable.pepe),
        contentDescription = "Example",
        alpha = 2.0f

    )

}
