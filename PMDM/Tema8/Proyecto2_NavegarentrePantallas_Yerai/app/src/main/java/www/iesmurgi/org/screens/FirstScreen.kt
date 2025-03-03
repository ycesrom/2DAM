package www.iesmurgi.org.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import www.iesmurgi.org.Persona
import www.iesmurgi.org.R
import www.iesmurgi.org.navegation.AppScreen

@Composable
fun FirstScreen(navController: NavController)
{
    Scaffold { paddingValues -> BodyContent(paddingValues, navController)  }
}

@Composable
fun BodyContent(paddingValues: PaddingValues, navController: NavController)
{
    Column(modifier = Modifier.fillMaxSize().padding(paddingValues),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {Text(text = stringResource(R.string.welcome_message))  // ✅ Se traducirá automáticamente
        MiRecyclerView(navController)
    }
}

@Composable
fun MiRecyclerView(navController: NavController)
{ LazyColumn{
    items(getProfesores()){ profesor ->
            ItemProfe(profe=profesor,navController)
        }
    }
}
@Composable
fun ItemProfe(profe: Persona,navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)) { Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = profe.foto),
                contentDescription = "Profile image of ${profe.nombre}",
                modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape)
                    .border(1.dp, Color.Gray, CircleShape) )
            Spacer(modifier = Modifier.padding(8.dp))
            Column {
                Text(
                    text = profe.nombre,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = profe.email,
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = profe.asignatura,
                    style = MaterialTheme.typography.bodySmall) } }
        Button(onClick = { navController.navigate("${AppScreen.SecondScreen.route}/${profe.email}") }) {
            Text(text = stringResource(R.string.navigate_button)) } }
}
fun getProfesores():List<Persona>{
    return listOf(
        Persona("Ana","tata@gmail.com","moviles", R.drawable.murgi),
        Persona("Carlos","tata@gmail.com","moviles", R.drawable.murgi),
        Persona("Fede","tata@gmail.com","moviles", R.drawable.murgi),
        Persona("Sole","tata@gmail.com","moviles", R.drawable.murgi))
}




