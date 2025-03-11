package www.iesmurgi.org.Detail

import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.IconButton
import androidx.compose.material3.Icon
import androidx.compose.material.icons.filled.ShoppingCart
import android.annotation.SuppressLint
import android.app.Activity
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailScreen(navController: NavController, name: String, email: String, contador:Int) {
    var inputName by rememberSaveable { mutableStateOf(name) }
    var inputEmail by rememberSaveable { mutableStateOf(email) }
    val context = LocalContext.current
    val activity = context as? Activity
    var cartCount by rememberSaveable { mutableStateOf(0) }
    // Incrementa el contador solo la primera vez que se entra a esta pantalla


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Tienda Online") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Volver")
                    }
                },

                actions = {
                   BadgeBoxCarrito(cartCount)


                }
            )
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



            Spacer(modifier = Modifier.height(16.dp))

            // Botón para añadir productos al carrito
            Button(
                onClick = { cartCount++ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Añadir al Carrito")
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Botón para vaciar el carrito
            Button(
                onClick = { cartCount = 0 },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
            ) {
                Text("Vaciar Carrito")
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text("Contador de alumnos: $contador", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        }
    }
}

@Composable
fun BadgeBoxCarrito(cartCount: Int) {
    BadgedBox(
        badge = {
            if (cartCount > 0) {
                Badge(
                    containerColor = Color.Red,
                    contentColor = Color.White
                ) {
                    Text("$cartCount")
                }
            }
        }
    ) {
        IconButton(onClick = { /* Acción cuando se presiona el carrito */ }) {
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = "Carrito de la compra"
            )
        }
    }
}