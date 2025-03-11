package www.iesmurgi.org


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import www.iesmurgi.org.Detail.DetailScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "list" ) {
                composable("pant") {
                    pantalla(navController)
                }
                composable("login") {
                    LoginScreen(navController)
                }
                composable("list") {
                    StudentListScreen(navController)
                }
                composable("detail/{name}/{email}/{contador}") { backStackEntry ->
                    val name = backStackEntry.arguments?.getString("name") ?: "Desconocido"
                    val email = backStackEntry.arguments?.getString("email") ?: "Sin correo"
                    val contadorActual = backStackEntry.arguments?.getString("contador")?.toIntOrNull() ?: 0

                    DetailScreen(navController, name, email,contadorActual)
                }
            }
        }
    }
}
