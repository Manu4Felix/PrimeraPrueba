import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun Ejercicio1_CalculaPropina() {

    var precioTotal: String by remember { mutableStateOf("") }
    var porcentajePropina: String by remember { mutableStateOf("") }
    var showText: Boolean by remember { mutableStateOf(false) }
    var propina: Double by remember { mutableDoubleStateOf(0.0)}
    var precioFinal: Double by remember { mutableDoubleStateOf(0.0)}

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = precioTotal,
            onValueChange = { precioTotal = it },
            label = { Text("Precio total del menú") }
        )

        TextField(
            value = porcentajePropina,
            onValueChange = { porcentajePropina = it },
            label = { Text("Porcentaje de propina") }
        )
        Button(
            onClick = {
            showText = true
            propina = porcentajePropina.toDouble() / 100 * precioTotal.toDouble()
            precioFinal =
                precioTotal.toDouble() + propina
        }) {
            Text("Calcular")
        }

        if (showText) {
            Text("La propina es: $propina" + "€")
            Text("El precio total a pagar es: $precioFinal" + "€")
        }

    }
}