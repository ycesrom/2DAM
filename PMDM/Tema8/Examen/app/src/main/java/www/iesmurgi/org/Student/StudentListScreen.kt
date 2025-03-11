package www.iesmurgi.org.Student

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import www.iesmurgi.org.R
import www.iesmurgi.org.data.Student

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentListScreen(navController: NavController) {
    var contador by rememberSaveable { mutableStateOf(0) } // Contador Local

    val students = listOf(
        Student("Ayman", "Matemáticas", "Ayman@example.com", R.drawable.aymancharchaoui),
        Student("Bernardo", "Ciencias", "Bernardo@example.com", R.drawable.bernardorodriguezlinares),
        Student("Ruben", "Historia", "Ruben@example.com", R.drawable.fotoruben),
        Student("Alexandru", "Lengua", "Alex@example.com", R.drawable.alexandruanutapreda),
        Student("Jose", "Arte", "Jose@example.com", R.drawable.img20241111222727),
        Student("Marco", "Música", "Marco@xample.com", R.drawable.img20240923143611),
        Student("Jose", "Educación Física", "jose@example.com", R.drawable.img20241016163828),
        Student("Javi", "Informática", "javi@example.com", R.drawable.javiecampoylozano),
        Student("Jorge", "Filosofía", "alumno9@example.com", R.drawable.jorgevizcainomaldonado),
        Student("Oscar", "Química", "alumno10@example.com", R.drawable.oscarabellan),
        Student("Walther", "Física", "alumno11@example.com", R.drawable.waltheralexandro),
        Student("Lubo", "Biología", "alumno12@example.com", R.drawable.whatsappimage20240923143650),
        Student("Vili", "Geografía", "alumno13@example.com", R.drawable.whatsappimage20241030132125),
        Student("Alessia", "Economía", "alumno14@example.com", R.drawable.alessiaoliveratorres),
        Student("Angel", "Tecnología", "alumno15@example.com", R.drawable.angelfloro),
        Student("Angel M.", "Inglés", "alumno16@example.com", R.drawable.angelmiguelmunoz),
        Student("Clara", "Francés", "alumno17@example.com", R.drawable.clararoldanperez),
        Student("Moha F.", "Alemán", "alumno18@example.com", R.drawable.farismohamedamine),
        Student("Moha A.", "Italiano", "alumno19@example.com", R.drawable.foto),
        Student("Javier", "Japonés", "alumno20@example.com", R.drawable.javiercortes),
        Student("Juanra", "Francés", "alumno17@example.com", R.drawable.juanramonpereztoledo),
        Student("Lucia", "Alemán", "alumno18@example.com", R.drawable.lucia),
        Student("Oscar B", "Italiano", "alumno19@example.com", R.drawable.oscarbono),
        Student("Sergey", "Japonés", "alumno20@example.com", R.drawable.sergeytereshkov),
        Student("Yerai", "Francés", "alumno17@example.com", R.drawable.yerai)
    )

    Column {
        Text(
            text = stringResource(R.string.student_list_screen_title),
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(16.dp)
        )
        LazyColumn {

            items(students) { student ->
                StudentItem(student) {
                    contador++
                    navController.navigate("detail/${student.name}/${student.email}/$contador")
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
            .clickable { onClick()
            }
            .border(1.dp, Color.Gray),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = student.foto),
                contentDescription = "Imagen de ${student.name}",
                modifier = Modifier.size(50.dp)
            )
            Spacer(modifier = Modifier.size(16.dp))
            Column {
                Text(text = student.name, fontWeight = FontWeight.Bold)
                Text(text = student.subject)
                Text(text = student.email)
            }
        }
    }
}
