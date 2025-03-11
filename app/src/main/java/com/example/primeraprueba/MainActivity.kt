package com.example.primeraprueba

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.primeraprueba.ui.theme.PrimeraPruebaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PrimeraPruebaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Manuel",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    ConstraintLayout(modifier.fillMaxSize()) {
        val (boxRed, boxYellow, boxGreen, boxCyan, boxMagenta) = createRefs()
        Box(modifier = Modifier.size(120.dp).background(Color.Red).constrainAs(boxRed){
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })
        Box(modifier = Modifier.size(120.dp).background(Color.Yellow).constrainAs(boxYellow){
            start.linkTo(boxRed.start)
            bottom.linkTo(boxRed.top)
        })
        Box(modifier = Modifier.size(120.dp).background(Color.Green).constrainAs(boxGreen){
            start.linkTo(boxRed.start)
            top.linkTo(boxRed.bottom)
        })
        Box(modifier = Modifier.size(120.dp).background(Color.Cyan).constrainAs(boxCyan){
            end.linkTo(boxRed.start)
            top.linkTo(boxRed.top)
        })
        Box(modifier = Modifier.size(120.dp).background(Color.Magenta).constrainAs(boxMagenta){
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


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    PrimeraPruebaTheme {
        Greeting("Manuel")
    }
}