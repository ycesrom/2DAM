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
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { GreetingPreview()
        }
    }
}

@Composable
fun MenuBasicoDropdownMenu() {
    var expanded by remember { mutableStateOf(false) }
    val androidVersions = listOf(
        "Cupcake", "Donut", "Eclair", "Froyo", "Gingerbread", "Honeycomb", "Ice Cream Sandwich",
        "Jelly Bean", "KitKat", "Lollipop", "Marshmallow", "Nougat", "Oreo", "Pie", "Android 10",
        "Android 11", "Android 12", "Android 13", "Android 14"
    )

    Box(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Top)
        {
            Spacer(modifier = Modifier.padding(20.dp))
            Text(text = "Menú Básico", style = MaterialTheme.typography.headlineMedium)


            IconButton(onClick = { expanded = !expanded }) {
                Icon(Icons.Default.Menu, contentDescription = "Menú Basico")
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
               androidVersions.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = { /* Do something... */ }
                    )
                }
            }
        }
    }
}

@Composable
fun DropdownMenuAvanzado() {
    var expanded by remember { mutableStateOf(false) }

        Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

            ) {
            Text(text = "Menú Avanzado", style = MaterialTheme.typography.headlineMedium)
        IconButton(onClick = { expanded = !expanded }) {
            Icon(Icons.Default.Menu, contentDescription = "Menú Avanzado")
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            // First section
            DropdownMenuItem(
                text = { Text("Perfil") },
                leadingIcon = { Icon(Icons.Outlined.Person, contentDescription = "Perfil") },
                onClick = { /* Do something... */ }
            )
            DropdownMenuItem(
                text = { Text("Ajustes") },
                leadingIcon = { Icon(Icons.Outlined.Settings, contentDescription = "Ajustes") },
                onClick = { /* Do something... */ }
            )

            HorizontalDivider()

            // Second section
            DropdownMenuItem(
                text = { Text("Enviar Retroalimentación") },
                leadingIcon = { Icon(Icons.Outlined.Info, contentDescription ="Retroalimentación") },
                trailingIcon = { Icon(Icons.AutoMirrored.Outlined.Send, contentDescription = "Enviar") },
                onClick = { /* Do something... */ }
            )

            HorizontalDivider()

            // Third section
            DropdownMenuItem(
                text = { Text("Acerca de") },
                leadingIcon = { Icon(Icons.Outlined.Info, contentDescription = null) },
                onClick = { /* Do something... */ }
            )
            DropdownMenuItem(
                text = { Text("Ayuda") },
                leadingIcon = { Icon(Icons.AutoMirrored.Outlined.List, contentDescription = null) },
                trailingIcon = { Icon(Icons.AutoMirrored.Outlined.ExitToApp, contentDescription = null) },
                onClick = { /* Do something... */ }
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview()
{
    MenuBasicoDropdownMenu()
    DropdownMenuAvanzado()

}