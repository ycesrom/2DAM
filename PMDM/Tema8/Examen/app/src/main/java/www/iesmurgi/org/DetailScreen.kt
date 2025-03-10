package www.iesmurgi.org

import android.annotation.SuppressLint
import android.app.Activity
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailScreen(navController: NavController, name: String, email: String) {
    var inputName by rememberSaveable { mutableStateOf(name) }
    var inputEmail by rememberSaveable { mutableStateOf(email) }
    var visitCount by rememberSaveable { mutableStateOf(0) }
    val context = LocalContext.current
    val activity = context as? Activity

    // Incrementa el contador solo la primera vez que se entra a esta pantalla
    LaunchedEffect(name) {
        visitCount++
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Detalles del Alumno") })
        }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Spacer(modifier = Modifier.padding(30.dp))


            OutlinedTextField(
                value = inputName,
                onValueChange = { inputName = it },
                label = { Text("Nombre") }
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = inputEmail,
                onValueChange = { inputEmail = it },
                label = { Text("Email") }
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row {
                Button(
                    onClick = {
                        inputName = ""
                        inputEmail = ""
                        Toast.makeText(context, "Campos limpiados", Toast.LENGTH_SHORT).show()
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Limpiar")
                }

                Spacer(modifier = Modifier.width(8.dp))

                Button(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Volver")
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = { activity?.finishAffinity() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Salir de la App")
            }

            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Visitas: $visitCount", style = MaterialTheme.typography.bodyLarge)
        }
    }
}

