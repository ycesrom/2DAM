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
    val versionAndroid = listOf("Android 1.0", "Android 2.0", "Android 3.0","Android 5.0","Android 6.0")
    val subVersions = mapOf(
        "Android 1.0" to listOf("10.0", "10.1"),
        "Android 2.0" to listOf("11.0", "11.1"),
        "Android 3.0" to listOf("12.0", "12.1", "12L"),
        "Android 5.0" to listOf("13.0", "13.1")
    )


    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.End
    )
    {
        Spacer(modifier = Modifier.padding(16.dp))
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
                    subVersions[selectedVersion]?.forEach { subVersion ->
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