package www.iesmurgi.org.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import www.iesmurgi.org.R


@Composable
fun SecondScreen(navController: NavController, backStackEntry: NavBackStackEntry) {
    val email = backStackEntry.arguments?.getString("email") ?: "No disponible"

    Scaffold { paddingValues ->SecondBodyContent(paddingValues,navController,email)  }
}

@Composable
fun SecondBodyContent(paddingValues: PaddingValues, navController: NavController,email:String?)
{
    Column(modifier = Modifier.fillMaxSize().padding(paddingValues),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Text(text = stringResource( R.string.navigate))
        Text(text = "${stringResource(R.string.email_profesor)} $email", fontWeight = FontWeight.Bold)
        email?.let { Text(it) }
        Button(onClick = { navController.popBackStack()  })
        {
            Text(text = stringResource(R.string.navigate_back))
        }
    }
}



