package www.iesmurgi.org

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import www.iesmurgi.org.ui.theme.U5_Proyecto3_Switch_YeraiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            U5_Proyecto3_Switch_YeraiTheme {
                // Se llama a la función MyPreview para mostrar la interfaz
                MyPreview()
            }
        }
    }
}

// Composable que define la estructura de la interfaz de usuario
@Composable
fun MySwitch(modifier: Modifier = Modifier) {

    // Caja para mostrar una imagen circular en la parte superior derecha
    Box(modifier = Modifier.fillMaxSize().padding(top = 100.dp).padding(end = 10.dp), contentAlignment = Alignment.TopEnd) {
        val image1 = painterResource(R.drawable.f1) // Carga de la imagen desde los recursos
        CircularImage(image1) // Muestra la imagen en forma circular
    }

    // Caja para mostrar un ícono en la parte superior izquierda
    Box(modifier = Modifier.fillMaxSize().padding(top = 100.dp).padding(end = 10.dp), contentAlignment = Alignment.TopStart) {
        val icon = Icons.Filled.Home // Se usa un ícono de casa (Home)
        IconImage(icon) // Muestra el ícono
    }

    // Caja para mostrar una imagen normal centrada en la parte superior
    Box(modifier = Modifier.fillMaxWidth().padding(top = 300.dp), contentAlignment = Alignment.TopCenter) {
        val image2 = painterResource(R.drawable.f1logo) // Carga de la imagen desde los recursos
        NormalImage(image2) // Muestra la imagen normalmente
    }

    // Variables para almacenar el estado de los interruptores (Switch)
    var checked1 by remember { mutableStateOf(true) }
    var checked2 by remember { mutableStateOf(true) }
    var checked3 by remember { mutableStateOf(true) }
    var checked4 by remember { mutableStateOf(true) }

    // Columna que organiza los interruptores y las etiquetas
    Column(
        modifier = Modifier.fillMaxSize().padding(top = 200.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Fila que contiene los interruptores
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Caja que contiene el primer interruptor con su etiqueta
            Box(
                modifier = Modifier
                    .border(2.dp, Color.Gray, shape = RoundedCornerShape(0.dp))
                    .padding(7.dp) // Espaciado interno
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Necesarias", modifier = Modifier.padding(bottom = 8.dp)) // Etiqueta
                    // Interruptor que cambia el valor de checked1
                    Switch(checked = checked1, onCheckedChange = { checked1 = it }, thumbContent = {
                        if (checked1) {
                            Icon(
                                imageVector = Icons.Filled.Check,
                                contentDescription = null,
                                modifier = Modifier.size(SwitchDefaults.IconSize),
                                tint = Color.Green // Color verde cuando está activado
                            )
                        } else {
                            Icon(
                                imageVector = Icons.Filled.Close,
                                contentDescription = "Unckede",
                                modifier = Modifier.size(SwitchDefaults.IconSize),
                                tint = Color.Red // Color rojo cuando está desactivado
                            )
                        }
                    })
                }
            }

            // Caja similar para el segundo interruptor
            Box(
                modifier = Modifier
                    .border(2.dp, Color.Gray, shape = RoundedCornerShape(0.dp))
                    .padding(7.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Preferencias", modifier = Modifier.padding(bottom = 8.dp)) // Etiqueta
                    // Interruptor que cambia el valor de checked2
                    Switch(checked = checked2, onCheckedChange = { checked2 = it }, thumbContent = {
                        if (checked2) {
                            Icon(
                                imageVector = Icons.Filled.Check,
                                contentDescription = "Checked",
                                modifier = Modifier.size(SwitchDefaults.IconSize),
                                tint = Color.Green
                            )
                        } else {
                            Icon(
                                imageVector = Icons.Filled.Close,
                                contentDescription = "Unckede",
                                modifier = Modifier.size(SwitchDefaults.IconSize),
                                tint = Color.Red
                            )
                        }
                    })
                }
            }

            // Caja similar para el tercer interruptor
            Box(
                modifier = Modifier
                    .border(2.dp, Color.Gray, shape = RoundedCornerShape(0.dp))
                    .padding(7.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Estadística", modifier = Modifier.padding(bottom = 8.dp))
                    // Interruptor que cambia el valor de checked3
                    Switch(checked = checked3, onCheckedChange = { checked3 = it }, thumbContent = {
                        if (checked3) {
                            Icon(
                                imageVector = Icons.Filled.Check,
                                contentDescription = null,
                                modifier = Modifier.size(SwitchDefaults.IconSize),
                                tint = Color.Green
                            )
                        } else {
                            Icon(
                                imageVector = Icons.Filled.Close,
                                contentDescription = "Unckede",
                                modifier = Modifier.size(SwitchDefaults.IconSize),
                                tint = Color.Red
                            )
                        }
                    })
                }
            }

            // Caja similar para el cuarto interruptor
            Box(
                modifier = Modifier
                    .border(2.dp, Color.Gray, shape = RoundedCornerShape(0.dp))
                    .padding(7.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Markerting", modifier = Modifier.padding(bottom = 8.dp))
                    // Interruptor que cambia el valor de checked4
                    Switch(checked = checked4, onCheckedChange = { checked4 = it }, thumbContent = {
                        if (checked4) {
                            Icon(
                                imageVector = Icons.Filled.Check,
                                contentDescription = null,
                                modifier = Modifier.size(SwitchDefaults.IconSize),
                                tint = Color.Green
                            )
                        } else {
                            Icon(
                                imageVector = Icons.Filled.Close,
                                contentDescription = "Unckede",
                                modifier = Modifier.size(SwitchDefaults.IconSize),
                                tint = Color.Red
                            )
                        }
                    })
                }
            }
        }
    }

    // Fila que contiene los botones en la parte inferior
    Row(modifier = modifier.fillMaxWidth().padding(bottom = 100.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.Bottom) {
        // Botón deshabilitado "Denegar"
        OutlinedButton(
            onClick = {},
            enabled = false,
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .weight(1f)
                .height(56.dp)
                .padding(horizontal = 4.dp)
                .border(2.dp, Color.Blue),
            colors = ButtonDefaults.buttonColors(
                disabledContentColor = Color.Black,
                disabledContainerColor = Color.White
            )
        ) {
            Text("Denegar")
        }

        // Botón deshabilitado "Permitir la selección"
        OutlinedButton(
            onClick = {},
            enabled = false,
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 4.dp)
                .border(2.dp, Color.Blue),
            colors = ButtonDefaults.buttonColors(
                disabledContentColor = Color.Black,
                disabledContainerColor = Color.White
            )
        ) {
            Text("Permitir la seleccion")
        }

        // Botón deshabilitado "Permitir Todas"
        OutlinedButton(
            onClick = {},
            enabled = false,
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 4.dp)
                .border(2.dp, Color.Blue),
            colors = ButtonDefaults.buttonColors(
                disabledContentColor = Color.White,
                disabledContainerColor = Color.Blue,
            )
        ) {
            Text("Permitir Todas")
        }
    }
}

// Función que muestra una imagen normal
@Composable
fun NormalImage(image: Painter) {
    Image(
        painter = image,
        contentDescription = null,
        modifier = Modifier
            .clip(RectangleShape).fillMaxWidth().height(200.dp),
        contentScale = ContentScale.FillBounds // Ajuste de imagen para cubrir el área
    )
}

// Función para mostrar un icono
@Composable
fun IconImage(icon: ImageVector) {
    Icon(
        imageVector = icon,
        contentDescription = "Icono",
        modifier = Modifier
            .size(70.dp) // Tamaño del icono
            .padding(16.dp), // Espaciado alrededor del icono
        tint = Color.Blue // Color del icono
    )
}

// Función que muestra una imagen circular
@Composable
fun CircularImage(image: Painter) {
    Image(
        painter = image,
        contentDescription = null,
        modifier = Modifier.size(100.dp).clip(CircleShape), // Imagen circular
        contentScale = ContentScale.Crop // Recorte de la imagen
    )
}

// Función que previsualiza la vista de la aplicación
@Preview(showBackground = true)
@Composable
fun MyPreview() {
    MySwitch(modifier = Modifier.fillMaxSize()) // Previsualiza el contenido de MySwitch
}
