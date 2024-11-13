package www.iesmurgi.org

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.Dimension

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
           GreetingPreview()
        }
    }
}

@Composable
fun ConstraintLayout()
{
    ConstraintLayout(modifier = Modifier.fillMaxSize())
    {
        val (box1, box2, box3, box4, space1,space2) = createRefs()
        Box(
            modifier = Modifier.constrainAs(box1)
            {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
            }
                .background(Color.Cyan)
                .height(300.dp)
                .fillMaxWidth()
                .width(400.dp)

        )
        Spacer(modifier = Modifier.height(30.dp).constrainAs(space1)
        {
            top.linkTo(box1.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)

        })

        Box(modifier = Modifier.constrainAs(box2)
        {
            top.linkTo(box1.bottom)
            start.linkTo(parent.start)

        }
            .background(Color.Red)
            .height(300.dp)
            .width(200.dp)
            .fillMaxHeight()


        )

        Box(modifier = Modifier.constrainAs(box3)
        {
            top.linkTo(box1.bottom)
            end.linkTo(parent.end)
        }
            .background(Color.Green)
            .height(300.dp)
            .width(200.dp)
        ){
                Text(
                    text = "Hola Clase 2ºDAM",
                    color = Color.Black,
                    modifier = Modifier.align(Alignment.Center) // Centramos el texto
                )
            }








        Spacer(modifier = Modifier.height(30.dp).constrainAs(space2)
        {
            top.linkTo(box2.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })

        Box(modifier = Modifier.size(400.dp).constrainAs(box4)
        {
            top.linkTo(box3.bottom)

        }
            .background(Color.Magenta)
            .height(100.dp)
            .fillMaxHeight()
        )





    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview()
{
    ConstraintLayout()

}