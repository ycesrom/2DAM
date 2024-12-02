package www.iesmurgi.org

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import www.iesmurgi.org.ui.theme.U5_Proyecto3_Switch_YeraiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            U5_Proyecto3_Switch_YeraiTheme {

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Row(modifier = Modifier.fillMaxSize().padding(innerPadding))
                    {


                    }
                    myPreview()

                }
            }
        }
    }
}
@Composable
fun mySwitch(name: String,modifier: Modifier=Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
    val image = painterResource(R.drawable.f1)
    Image(
        painter = image,
        contentDescription = null
    )


    var checked1 by remember { mutableStateOf(true) }
    var checked2 by remember { mutableStateOf(true) }
    var checked3 by remember { mutableStateOf(true) }
    var checked4 by remember { mutableStateOf(true) }

    Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically) {
        Switch(checked = checked1, onCheckedChange = { checked1=it }, thumbContent ={ if (checked1) {

                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = null,
                    modifier = Modifier.size(SwitchDefaults.IconSize),
                )

        } else {
            Icon(
                imageVector = Icons.Filled.Close,
                contentDescription = "Unckede", modifier = Modifier.size(SwitchDefaults.IconSize)
            )

        }
        })

        Switch(checked = checked2, onCheckedChange = { checked2=it }, thumbContent ={ if (checked2) {

                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = "Checked",
                    modifier = Modifier.size(SwitchDefaults.IconSize),
                )

        } else {
            Icon(
            imageVector = Icons.Filled.Close,
            contentDescription = "Unckede", modifier = Modifier.size(SwitchDefaults.IconSize)
        )
        }
        })
        Switch(checked = checked3, onCheckedChange = { checked3=it }, thumbContent ={ if (checked3) {

                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = null,
                    modifier = Modifier.size(SwitchDefaults.IconSize),
                )

        } else {
            Icon(
                imageVector = Icons.Filled.Close,
                contentDescription = "Unckede", modifier = Modifier.size(SwitchDefaults.IconSize)
            )
        }
        })
        Switch(checked = checked4, onCheckedChange = { checked4=it }, thumbContent ={ if (checked4) {

                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = null,
                    modifier = Modifier.size(SwitchDefaults.IconSize),
                )

        } else {
            Icon(
                imageVector = Icons.Filled.Close,
                contentDescription = "Unckede", modifier = Modifier.size(SwitchDefaults.IconSize)
            )
        }
        })

    }
}


@Preview(showBackground = true)
@Composable
fun myPreview()
{
    mySwitch("", modifier = Modifier.fillMaxSize())
}