package www.iesmurgi.org

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ExitToApp
import androidx.compose.material.icons.automirrored.outlined.List
import androidx.compose.material.icons.automirrored.outlined.Send
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import www.iesmurgi.org.ui.theme.U6Proyecto1_YeraiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GreetingPreview()

        }
    }
}

@Composable
fun MenuBasicoDropdownMenu() {
    var menuBasico by remember { mutableStateOf(false) }
    val versionesAndroid = listOf(
        "Cupcake", "Donut", "Eclair", "Froyo", "Gingerbread", "Honeycomb", "Ice Cream Sandwich",
        "Jelly Bean", "KitKat", "Lollipop", "Marshmallow", "Nougat", "Oreo", "Pie", "Android 10",
        "Android 11", "Android 12", "Android 13", "Android 14"
    )

    Box(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top)
        {
            Spacer(modifier = Modifier.padding(20.dp))
            Text(text = "Menú Básico", style = MaterialTheme.typography.headlineMedium)


            IconButton(onClick = { menuBasico = !menuBasico }) {
                Icon(Icons.Default.Menu, contentDescription = "Menú Basico")
            }
            DropdownMenu(
                expanded = menuBasico,
                onDismissRequest = { menuBasico = false }
            ) {
                versionesAndroid.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {  }
                    )
                }
            }
        }
    }
}

@Composable
fun DropdownMenuAvanzado() {
    var menuAvanzado by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Text(text = "Menú Avanzado", style = MaterialTheme.typography.headlineMedium)
        IconButton(onClick = {menuAvanzado = !menuAvanzado }) {
            Icon(Icons.Default.Menu, contentDescription = "Menú Avanzado")
        }
        DropdownMenu(
            expanded = menuAvanzado,
            onDismissRequest = { menuAvanzado = false }
        ) {
            // First section
            DropdownMenuItem(
                text = { Text("Llamar") },
                leadingIcon = { Icon(Icons.Outlined.Call, contentDescription = "Llamar") },
                onClick = {  }
            )
            HorizontalDivider(modifier = Modifier, thickness = 3.dp,Color.Black)
            DropdownMenuItem(
                text = { Text("Ajustes") },
                leadingIcon = { Icon(Icons.Outlined.Settings, contentDescription = "Ajustes") },
                onClick = {  }
            )

            HorizontalDivider(modifier = Modifier, thickness = 3.dp,Color.Black)

            // Segunda Sección
            DropdownMenuItem(
                text = { Text("Enviar Retroalimentación") },
                leadingIcon = { Icon(Icons.Outlined.Info, contentDescription ="Retroalimentación") },
                trailingIcon = { Icon(Icons.AutoMirrored.Outlined.Send, contentDescription = "Enviar") },
                onClick = {  }
            )

            HorizontalDivider(modifier = Modifier, thickness = 3.dp,Color.Black)

            // Tercera Sección
            DropdownMenuItem(
                text = { Text("Acerca de") },
                leadingIcon = { Icon(Icons.Outlined.Info, contentDescription = "Info") },
                onClick = {  }
            )
            HorizontalDivider(modifier = Modifier, thickness = 3.dp,Color.Black)
            DropdownMenuItem(
                text = { Text("Ayuda") },
                leadingIcon = { Icon(Icons.AutoMirrored.Outlined.List, contentDescription ="Ayuda") },
                trailingIcon = { Icon(Icons.AutoMirrored.Outlined.ExitToApp, contentDescription = "Salir de la App") },
                onClick = {  }
            )

        }
    }
}

@Composable
fun CarritoBadgeBox() {
    var contador by remember { mutableStateOf(0) }

    Column( modifier = Modifier.fillMaxSize().padding(20.dp),

        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Top

    ) {
        Spacer(modifier = Modifier.padding(25.dp))
        BadgedBox(
            badge = {
                if (contador > 0) {
                    Badge(
                        containerColor = Color.Red,
                        contentColor = Color.White
                    ) {
                        Text("$contador")
                    }
                }
            }
        ) {
            Icon(
                imageVector = Icons.Filled.ShoppingCart,
                contentDescription = "Carrito de la Compra",
            )
        }
        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center)

        { Spacer(modifier = Modifier.padding(80.dp))
            Button(onClick = { contador++ }) {
                Text("Añadir al carrito")
            }

            Button(onClick = {contador=0})
            {
                Text("Vacir el carrito")
            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MenuBasicoDropdownMenu()
    DropdownMenuAvanzado()
    CarritoBadgeBox()
}




