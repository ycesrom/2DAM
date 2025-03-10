package www.iesmurgi.org

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentListScreen(navController: NavController) {
    val students = listOf(
        Student("Juan Pérez", "juan@example.com", "Matemáticas", R.drawable.ic_launcher_background),
        Student("Ana López", "ana@example.com", "Historia", R.drawable.ic_launcher_background),
        Student("Carlos Gómez", "carlos@example.com", "Física", R.drawable.ic_launcher_background),
        Student("Laura Martínez", "laura@example.com", "Biología", R.drawable.ic_launcher_background),
        Student("Pedro Sánchez", "pedro@example.com", "Química", R.drawable.ic_launcher_background),
        Student("Sofia García", "sofia@example.com", "Filosofía", R.drawable.ic_launcher_background),
        Student("Miguel Rodríguez", "miguel@example.com", "Lengua", R.drawable.ic_launcher_background),
        Student("María Fernández", "maria@example.com", "Geografía", R.drawable.ic_launcher_background),
        Student("David Pérez", "david@example.com", "Matemáticas", R.drawable.ic_launcher_background),
        Student("Elena Gómez", "elena@example.com", "Historia", R.drawable.ic_launcher_background),
        Student("Antonio López", "antonio@example.com", "Física", R.drawable.ic_launcher_background),
        Student("Isabel Martín", "isabel@example.com", "Química", R.drawable.ic_launcher_background),
        Student("Fernando Sánchez", "fernando@example.com", "Biología", R.drawable.ic_launcher_background),
        Student("Raquel García", "raquel@example.com", "Filosofía", R.drawable.ic_launcher_background),
        Student("Javier Rodríguez", "javier@example.com", "Lengua", R.drawable.ic_launcher_background),
        Student("Carmen Fernández", "carmen@example.com", "Geografía", R.drawable.ic_launcher_background),
        Student("Luis Pérez", "luis@example.com", "Matemáticas", R.drawable.ic_launcher_background),
        Student("Patricia Gómez", "patricia@example.com", "Historia", R.drawable.ic_launcher_background),
        Student("Juan Carlos Martínez", "juancarlos@example.com", "Física", R.drawable.ic_launcher_background),
        Student("Ángeles López", "angeles@example.com", "Química", R.drawable.ic_launcher_background),
        Student("Daniel Sánchez", "daniel@example.com", "Biología", R.drawable.ic_launcher_background),
        Student("Marta Rodríguez", "marta@example.com", "Filosofía", R.drawable.ic_launcher_background),
        Student("Francisco García", "francisco@example.com", "Lengua", R.drawable.ic_launcher_background),
        Student("Sara Fernández", "sara@example.com", "Geografía", R.drawable.ic_launcher_background),
        Student("Víctor Pérez", "victor@example.com", "Matemáticas", R.drawable.ic_launcher_background),
        Student("Julia Gómez", "julia@example.com", "Historia", R.drawable.ic_launcher_background),
        Student("Luis Miguel Martín", "luismiguel@example.com", "Física", R.drawable.ic_launcher_background),
        Student("Alicia López", "alicia@example.com", "Química", R.drawable.ic_launcher_background),
        Student("Ricardo Sánchez", "ricardo@example.com", "Biología", R.drawable.ic_launcher_background),
        Student("Paula Rodríguez", "paula@example.com", "Filosofía", R.drawable.ic_launcher_background),
        Student("Antonio García", "antonio.garcia@example.com", "Lengua", R.drawable.ic_launcher_background),
        Student("Pedro Fernández", "pedro.fernandez@example.com", "Geografía", R.drawable.ic_launcher_background)
    )


    Scaffold(
        topBar = { TopAppBar(title = { Text("Lista de Alumnos") }) }
    ) {

        LazyColumn {

            items(students) { student ->
                StudentItem(student) {
                    navController.navigate("detail/${student.name}/${student.email}")
                }
            }
        }
    }
}

@Composable
fun StudentItem(student: Student, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },

    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            Spacer(modifier = Modifier.padding(30.dp))

            Image(
                painter = painterResource(id = student.imageRes),
                contentDescription = "Foto de ${student.name}",
                modifier = Modifier.size(64.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(text = student.name, style = MaterialTheme.typography.bodyLarge)
                Text(text = student.email, style = MaterialTheme.typography.bodyLarge)
                Text(text = student.subject, style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}
