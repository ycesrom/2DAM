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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import www.iesmurgi.org.ui.theme.U6Proyecto2_YeraiTheme

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
fun VersionesAndroid() {
    var menu1Expanded by remember { mutableStateOf(false) }
    var menu2Expanded by remember { mutableStateOf(false) }
    var selectedVersion by remember { mutableStateOf<String?>(null) }
    var selectedSubVersion by remember { mutableStateOf<String?>(null) }
    val versionAndroid = listOf(
        "Apple Pie", "Banana Bread", "Cupcake", "Donut", "Eclair", "Froyo", "Gingerbread", "Honeycomb",
        "Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow", "Nougat", "Oreo",
        "Pie", "Android 10", "Android 11", "Android 12", "Android 13", "Android 14"
    )

    val subVersionesAndroid = mapOf(
        "Apple Pie" to listOf("1.0"),
        "Banana Bread" to listOf("1.1"),
        "Cupcake" to listOf("1.5"),
        "Donut" to listOf("1.6"),
        "Eclair" to listOf("2.0", "2.1"),
        "Froyo" to listOf("2.2"),
        "Gingerbread" to listOf("2.3", "2.3.3", "2.3.4", "2.3.5", "2.3.6", "2.3.7"),
        "Honeycomb" to listOf("3.0", "3.1", "3.2"),
        "Ice Cream Sandwich" to listOf("4.0", "4.0.1", "4.0.2", "4.0.3", "4.0.4"),
        "Jelly Bean" to listOf("4.1", "4.2", "4.3"),
        "KitKat" to listOf("4.4", "4.4.1", "4.4.2", "4.4.3", "4.4.4"),
        "Lollipop" to listOf("5.0", "5.0.1", "5.0.2", "5.1", "5.1.1"),
        "Marshmallow" to listOf("6.0", "6.0.1"),
        "Nougat" to listOf("7.0", "7.1", "7.1.1", "7.1.2"),
        "Oreo" to listOf("8.0", "8.1"),
        "Pie" to listOf("9.0"),
        "Android 10" to listOf("10.0"),
        "Android 11" to listOf("11.0"),
        "Android 12" to listOf("12.0", "12L"),
        "Android 13" to listOf("13.0"),
        "Android 14" to listOf("14.0")
    )



    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.End
    )
    {
        Spacer(modifier = Modifier.padding(20.dp))
        Text(text = "Menú Anidado", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.padding(6.dp))
        Box {
            IconButton(onClick = { menu1Expanded = !menu1Expanded }) {
                Icon(Icons.Default.Menu, contentDescription = "Menú de versiones")
            }

            DropdownMenu(expanded = menu1Expanded, onDismissRequest = { menu1Expanded = false })
            {
                versionAndroid.forEach { version ->
                    DropdownMenuItem(
                        text = { Text(version) },
                        onClick = {
                            selectedVersion = version
                            selectedSubVersion = null // Reset subversion al cambiar la principal
                            menu1Expanded = false
                        })
                }
            }
        }
            Spacer(modifier = Modifier.height(16.dp))
            if (selectedVersion != null) {
                Text(
                    "Versión seleccionada: $selectedVersion",
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(8.dp))

                Box(modifier = Modifier.wrapContentSize()) {
                    Button(onClick = { menu2Expanded = true }) {
                        Text(selectedSubVersion ?: "Seleccionar subversión")

                DropdownMenu(
                    expanded = menu2Expanded,
                    onDismissRequest = { menu2Expanded = false }) {
                    subVersionesAndroid[selectedVersion]?.forEach { subVersion ->
                        DropdownMenuItem(
                            text = { Text(subVersion) },
                            onClick = {
                                selectedSubVersion = subVersion
                                menu2Expanded = false
                            }
                        )

                    }
                }
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    VersionesAndroid()

}