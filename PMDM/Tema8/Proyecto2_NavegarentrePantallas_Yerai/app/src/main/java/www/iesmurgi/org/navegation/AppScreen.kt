package www.iesmurgi.org.navegation

sealed class AppScreen(val route:String)
{
    object FirstScreen:AppScreen("first_screen")
    object SecondScreen:AppScreen("second_screen")
}