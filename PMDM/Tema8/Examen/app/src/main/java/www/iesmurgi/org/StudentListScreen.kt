package www.iesmurgi.org

import android.annotation.SuppressLint
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.NavController

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


                Scaffold(
        topBar = { TopAppBar(title = { Text("Lista de Alumnos") }) }
    ) {

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
    Spacer(modifier = Modifier.padding(30.dp))
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },

    ) {
        Row(modifier = Modifier.padding(8.dp)) {


            Image(
                painter = painterResource(id = student.foto),
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

