package www.iesmurgi.org

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

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
fun DialogWithImage(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    painter: Painter,
    imageDescription: String,
    icon: ImageVector,
    dialogTitle: String) {
    var open by remember { mutableStateOf(false) }
    Column(modifier = Modifier.padding(16.dp).fillMaxSize(), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    { Button(onClick = {open=true})
        { Text("Mostrar Dialogo Avanzado")
        } }
    if(open) {
        Dialog(onDismissRequest = { onDismissRequest() }) {
             Card(modifier = Modifier.fillMaxWidth().height(375.dp).padding(16.dp), shape = RoundedCornerShape(16.dp)) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(icon, contentDescription = "Icono")
                    Spacer(modifier = Modifier.padding(10.dp))
                        Text(text = dialogTitle, style = androidx.compose.ui.text.TextStyle.Default)
                    Image(
                        painter = painter,
                        contentDescription = imageDescription,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .height(160.dp))
                    Text(modifier = Modifier.padding(12.dp), text = "Esto es un dialogo Avazando con imagenes y botones e iconos")
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,) {
                        TextButton(onClick = { open=false }, modifier = Modifier.padding(8.dp)) {
                            Text("Cancelar") }
                        TextButton(onClick = { open=false },modifier = Modifier.padding(8.dp)) {
                            Text("Aceptar") } } } } } }
}
@Composable
fun AlertDialogExample(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogText: String,
    icon: ImageVector) {
    var open by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally)
    {
        Spacer(modifier = Modifier.padding(50.dp))
        Button(onClick = {open=true})
    {
        Text("Mostrar Dialogo Básico")
    }  }
    if(open) {
        AlertDialog(
            icon = {
                Icon(icon, contentDescription = "Icono") },
            title = {
                Text(text = dialogTitle) },
            text = {
                Text(text = dialogText) },
            onDismissRequest = {
                onDismissRequest() },
            confirmButton = {
                TextButton(
                    onClick = {
                        open = false }
                ) {
                    Text("Confirmar")
                } },
            dismissButton = {
                TextButton(
                    onClick = {
                        open = false }
                ) {
                    Text("Cancelar")
                } }) }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

    var onDismissRequest by remember { mutableStateOf(true) }
    var onConfirmation by remember { mutableStateOf(true) }
    val painter = painterResource(id = R.drawable.descargar)
    DialogWithImage(onDismissRequest = {onDismissRequest=false}, onConfirmation = {onConfirmation=false}, painter =painter , imageDescription = "Imagen Dialogo", icon = Icons.Default.Info ,"Ejemplo Alerta Dialogo")

   AlertDialogExample(onDismissRequest = {onDismissRequest=false}, onConfirmation = {onConfirmation=false}, dialogTitle = "Ejemplo Alerta Dialogo", dialogText = "Esto es un ejemplo de una alerta dialogo con botones ", icon = Icons.Default.Info)

}