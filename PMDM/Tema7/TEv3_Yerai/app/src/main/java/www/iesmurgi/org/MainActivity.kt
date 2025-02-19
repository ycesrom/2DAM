package www.iesmurgi.org

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.outlined.List
import androidx.compose.material.icons.automirrored.outlined.Send
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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

fun Body()
{

    MyToolbar(title = "Yerai", onNavigationIconClick = {})
    ProgressBarPantalla()
    BadgeBoxCarrito()
    SliderDeUnoaCincuenta()
    MenuCiclos()

}
@Composable
fun ProgressBarPantalla() {
    var showCircularProgress by remember { mutableStateOf(false) }
    var showLinearProgress by remember { mutableStateOf(false) }
    var circularProgress by remember { mutableFloatStateOf(0f) }


    val animatedCircularProgress by animateFloatAsState(
        targetValue = circularProgress,
        animationSpec = tween(durationMillis = 500),
        label = "Animacion Progreso Circular"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        if (showCircularProgress) {
            CircularProgressIndicator(
                progress = { animatedCircularProgress },
                modifier = Modifier.size(100.dp),
                color = Color.Magenta,
                strokeWidth = 8.dp,
            )
        }

        Spacer(modifier = Modifier.height(16.dp))


        if (showLinearProgress) {
            LinearProgressIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp),
                color = Color.Green,
                trackColor = Color.Blue
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { showCircularProgress = !showCircularProgress }) {
                Text(text = if (showCircularProgress) "Ocultar Circular" else "Accediendo")
            }
            Button(onClick = { showLinearProgress = !showLinearProgress }) {
                Text(text = if (showLinearProgress) "Ocultar Lineal" else "Enviado")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = {
                if (circularProgress < 1f) {
                    circularProgress += 0.1f
                }
            }) {
                Text(text = "Incrementar")
            }
            Button(onClick = {
                if (circularProgress > 0f) {
                    circularProgress -= 0.1f
                }
            }) {
                Text(text = "Decrementar")
            }
        }
        Spacer(modifier = Modifier.height(32.dp))

    }
}


@Composable
fun BadgeBoxCarrito() {
    var itemCount by remember { mutableIntStateOf(0) }

    Column( modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        horizontalAlignment =   Alignment.Start,
        verticalArrangement = Arrangement.Center

    )

    {


        BadgedBox(
            badge = {
                if (itemCount > 0) {
                    Badge(
                        containerColor = Color.Red,
                        contentColor = Color.White
                    ) {
                        Text("$itemCount")
                    }
                }
            }
        ) {


            Icon(
                imageVector = Icons.Filled.ShoppingCart,
                contentDescription = "Carrito de la compra",

            )
        }

        Spacer(modifier = Modifier.padding(250.dp))
        Button(onClick = { itemCount++ }) {
            Text("Comprar")
        }

        Button(onClick = {itemCount=0})
        {
            Text("Vaciar el carrito")
        }
    }
}

@Composable
fun SliderDeUnoaCincuenta() {
    var sliderPosition by remember { mutableFloatStateOf(0f) }
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(30.dp), verticalArrangement = Arrangement.Center) {

        Spacer(modifier = Modifier.padding(150.dp))
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            valueRange = 0f..50f,
            steps = 49,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            colors = SliderDefaults.colors(
                thumbColor = Color.Red,
                activeTrackColor = Color.Blue,
                inactiveTrackColor = Color.LightGray
            )
        )
        Text(text = "Valor del Slider: ${sliderPosition.toInt()}", fontSize = 18.sp)
    }
    }


@Composable
fun MenuCiclos() {
    var menu1Expanded by remember { mutableStateOf(false) }
    var menu2Expanded by remember { mutableStateOf(false) }
    var selectedVersion by remember { mutableStateOf<String?>(null) }
    var selectedSubVersion by remember { mutableStateOf<String?>(null) }
    val grados = listOf(
        "CF Grado Superior","CF Grado Medio","CF grado básica","Cursos de cualificación"
    )

    val ciclos= mapOf(
        "CF Grado Superior" to listOf("DAM","DAW","ASIR"),
        "CF Grado Medio" to listOf("SMR"),
        "CF grado básica" to listOf("Informática de Oficina","Informática y comunicaciones"),
        "Cursos de cualificación" to listOf("videojuegos y realidad virtual", "ciberseguridad","inteligencia artificial y bigdata")
    )




    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.End
    )
    {
        Spacer(modifier = Modifier.padding(60.dp))
        Text(text = "Menú Anidado", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.padding(6.dp))
        Box {
            IconButton(onClick = { menu1Expanded = !menu1Expanded }) {
                Icon(Icons.Default.Menu, contentDescription = "Menú de versiones")
            }

            DropdownMenu(expanded = menu1Expanded, onDismissRequest = { menu1Expanded = false })
            {
                grados.forEach { version ->
                    DropdownMenuItem(
                        text = { Text(version) },
                        onClick = {
                            selectedVersion = version
                            selectedSubVersion = null
                            menu1Expanded = false
                        },trailingIcon = { Icon(Icons.AutoMirrored.Outlined.List, contentDescription = "Menú") })
                    HorizontalDivider(modifier = Modifier, thickness = 3.dp,Color.Black)
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        if (selectedVersion != null) {
            Text(
                "Grado seleccionado: $selectedVersion",
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.height(8.dp))

            Box(modifier = Modifier.wrapContentSize()) {
                Button(onClick = { menu2Expanded = true }) {
                    Text(selectedSubVersion ?: "Seleccionar ciclo")


                    DropdownMenu(
                        expanded = menu2Expanded,
                        onDismissRequest = { menu2Expanded = false }) {

                        ciclos[selectedVersion]?.forEach { subVersion ->
                            DropdownMenuItem(

                                text = { Text(subVersion) },
                                trailingIcon = { Icon(Icons.AutoMirrored.Outlined.Send, contentDescription = "Enviar") },
                                onClick = {
                                    selectedSubVersion = subVersion
                                    menu2Expanded = false
                                }

                            )
                            HorizontalDivider(modifier = Modifier, thickness = 3.dp,Color.Black)

                        }
                    }
                }



            }
            Spacer(modifier = Modifier.padding(10.dp))
            if (selectedSubVersion != null) {
                Text(
                    "Ciclo seleccionado: $selectedSubVersion",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyToolbar(
    title: String,
    onNavigationIconClick: () -> Unit,
    showNavigationIcon: Boolean = true
) {
    Spacer(modifier = Modifier.padding(30.dp))
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.Blue,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White,
            actionIconContentColor = Color.White
        ),
        title = {
            Text(
                title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },

        navigationIcon = {

            if (showNavigationIcon) {
                IconButton(onClick = onNavigationIconClick) {

                    Icon(
                        imageVector = Icons.Filled.ShoppingCart,
                        contentDescription = "Carrito de la compra"
                    )
                }
            }
        },


        actions = {

            IconButton(onClick = {  }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Action Icon"
                )
            }
        }
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

    Body()
}