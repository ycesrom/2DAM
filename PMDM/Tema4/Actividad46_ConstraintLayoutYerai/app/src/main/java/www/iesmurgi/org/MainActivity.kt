package www.iesmurgi.org

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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
fun ConstraintLayoutExample() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        // Definimos las referencias para las cajas y los espacios
        val (box1, box2, box3, box4, space1, space2) = createRefs()

        // Caja 1 (Cyan)
        Box(
            modifier = Modifier
                .constrainAs(box1) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
                .background(Color.Cyan)
                .height(300.dp)  // Tamaño más pequeño para dejar espacio para los Spacer
                .fillMaxWidth()
        )

        // Spacer 1 (entre box1 y box2) - más alto para hacerlo visible
        Spacer(
            modifier = Modifier
                .height(30.dp)  // Aumento la altura del Spacer
                .constrainAs(space1) {
                    top.linkTo(box1.bottom)  // Spacer debajo de box1
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        // Caja 2 (Roja)
        Box(
            modifier = Modifier
                .constrainAs(box2) {
                    top.linkTo(space1.bottom)  // Box2 debajo del Spacer
                    start.linkTo(parent.start)
                }
                .background(Color.Red)
                .height(300.dp)  // Caja 2 más pequeña para probar
                .width(200.dp)
        )

        // Caja 3 (Verde) con texto centrado
        Box(
            modifier = Modifier
                .constrainAs(box3) {
                    top.linkTo(space1.bottom)  // Box3 debajo del Spacer
                    end.linkTo(parent.end)
                }
                .background(Color.Green)
                .height(300.dp)  // Caja 3 con altura ajustada
                .width(200.dp)
        ) {
            Text(
                text = "Hola Clase 2ºDAM",
                color = Color.Black,
                modifier = Modifier.align(Alignment.Center)  // Centramos el texto
            )
        }

        // Spacer 2 (entre box3 y box4) - más alto para hacerlo visible
        Spacer(
            modifier = Modifier
                .height(30.dp)  // Aumento la altura del Spacer
                .constrainAs(space2) {
                    top.linkTo(box3.bottom)  // Spacer debajo de box3
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        // Caja 4 (Magenta)
        Box(
            modifier = Modifier
                .constrainAs(box4) {
                    top.linkTo(space2.bottom)  // Box4 debajo del Spacer
                }
                .background(Color.Magenta)
                .height(300.dp)
                .fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ConstraintLayoutExample()
}
