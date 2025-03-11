package www.iesmurgi.org

import androidx.annotation.DrawableRes


data class Student(
    val name: String,
    val email: String,
    val subject: String,
     @DrawableRes val foto: Int
)

