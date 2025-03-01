package www.iesmurgi.org.navegation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import www.iesmurgi.org.screens.FirstScreen
import www.iesmurgi.org.screens.SecondScreen

@Composable
fun AppNavigation()
{

    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = AppScreen.FirstScreen.route)
    {
        composable(route = AppScreen.FirstScreen.route){
            FirstScreen(navController)
        }

        composable(route = AppScreen.SecondScreen.route + "/{email}",
            arguments = listOf(navArgument("email") { type = NavType.StringType })
        ) { backStackEntry ->
            SecondScreen(navController, backStackEntry)
        }


    }


}