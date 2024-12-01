package www.iesmurgi.org

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MonotonicFrameClock
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import www.iesmurgi.org.ui.theme.ComponentesTheme

class MainActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent{
            ComponentesTheme{


            }
        }
    }

    @Composable
    fun miText(modifier: Modifier)
    {
        Column(Modifier.fillMaxSize())
        {
            Text(text = "Esto es un ejemplo")
            Text(text = "Esto es un ejemplo", color = Color.Blue)
            Text(text = "Esto es un ejemplo", fontWeight = FontWeight.ExtraBold)
            Text(text = "Esto es un ejemplo", fontWeight = FontWeight.Light)
            Text(text = "Esto es un ejemplo", style= TextStyle(fontFamily = FontFamily.Cursive))
            Text(text = "Esto es un ejemplo", style= TextStyle(textDecoration = TextDecoration.LineThrough))
            Text(text = "Esto es un ejemplo", style=TextStyle(textDecoration = TextDecoration.Underline))
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview()
    {
        miText(Modifier)
    }
}
