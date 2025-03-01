package www.iesmurgi.org

import androidx.annotation.DrawableRes

data class Persona(var nombre:String,var email:String,var asignatura:String,
    @DrawableRes var foto:Int)
{

}
