package com.evaluacion1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.sp

class HonorariumCalculation : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Screen()
        }
    }
}


@Preview
@Composable
fun Screen() {
    //Obtenemos el contexto actual para usarlo en la navegación
    val context = LocalContext.current;

    // variables de estado para manejar el sueldo ingresado y el resultado
    var salario by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    //diseño de la pantalla con un fondo blanco y padding
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = 30.dp, start = 10.dp, end = 10.dp)
    ) {
            Box {
                // Botón para regresar a la vista anterior
                IconButton(
                    onClick = {
                        // Inicia la actividad principal cuando se presiona el botón
                        val intent = Intent(context, MainActivity::class.java)
                        context.startActivity(intent)
                    },
                    colors = IconButtonDefaults.filledIconButtonColors(),
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Volver"
                    )
                }
            }
            // Contenedor para los elementos principales: campo de texto y botones
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {
                // Muestra el resultado del cálculo
                Text(
                    text = result,
                    fontSize = 30.sp
                )
                Spacer(modifier = Modifier.height(16.dp))
                // Campo de texto para ingresar el sueldo
                TextField(
                    value = salario,
                    onValueChange = { salario = it },
                    placeholder = { Text("Ingrese Sueldo") },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                // Botón para calcular el sueldo líquido
                Button(onClick = {
                    // Convierte el sueldo ingresado a Double y calcula el sueldo líquido
                    val salario = salario.toDoubleOrNull() ?: 0.0
                    val calcular = EmpleadoHonorarios(salario).calcularLiquido()
                    result = "El suedo es: $calcular"
                }) {
                    Text(text = "Calcular")
                }
            }

    }
}