package com.example.sda2practica

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sda2practica.ui.theme.SDA2PracticaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SDA2PracticaTheme {
                PantallaBotones()
            }
        }
    }
}

@Composable
fun PantallaBotones() {
    var mostrarDialogo by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Button(
            onClick = { println("Boton presionado") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Boton simple")
        }

        Spacer(modifier = Modifier.height(20.dp))


        Button(
            onClick = { mostrarDialogo = true },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("mmostrar alerta")
        }


        if (mostrarDialogo) {
            AlertDialog(
                onDismissRequest = { mostrarDialogo = false },
                title = { Text(text = "Alerta") },
                text = { Text(text = "Este es un mensaje controlado") },
                confirmButton = {
                    TextButton(onClick = { mostrarDialogo = false }) {
                        Text("Aceptar")
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewPantalla() {
    SDA2PracticaTheme {
        PantallaBotones()
    }
}