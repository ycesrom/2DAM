package www.iesmurgi.org

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import www.iesmurgi.org.ui.theme.ReciclerView_YeraiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            }
        }
    }


@Preview
@Composable
fun MiRecyclerView()
{
    LazyColumn{

        items(getProfesores()){ profesor ->
            ItemProfe(profe=profesor)


        }
    }
}

@Composable
fun ItemProfe(profe: Persona) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = profe.foto),
                contentDescription = "Profile image of ${profe.nombre}", // Provide a content description
                modifier = Modifier
                    .size(32.dp) // Smaller size for the image
                    .clip(CircleShape) // Clip to a circle
                    .border(1.dp, Color.Gray, CircleShape) // Add a border
            )




            Spacer(modifier = Modifier.padding(8.dp))

            // Display the text information
            Column {

                Text(
                    text = profe.nombre,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = profe.asignatura,
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = profe.email,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}
// Se encargara de pintar cada uno de los elementos del recyclerView.
/*
@Composable
fun ItemProfe(profe:Persona)
{
    Card(border = BorderStroke(2.dp, Color.Green))
    {
        profe.toString()
    }

}
*/
fun getProfesores():List<Persona>{

    return listOf(
    Persona("Ana","moviles","tata@gmail.com",R.drawable.murgi),
    Persona("Carlos","moviles","tata@gmail.com",R.drawable.murgi),
    Persona("Fede","moviles","tata@gmail.com",R.drawable.murgi),
    Persona("Sole","moviles","tata@gmail.com",R.drawable.murgi)
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

}