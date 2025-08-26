package tips.my2cents.navigationsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import tips.my2cents.navigationsample.ui.theme.NavigationSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationSampleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}


@Composable
fun MyApp(modifier: Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "firstScreen") {
        composable(route = "firstScreen") {
            FirstScreen { name -> navController.navigate("secondScreen/$name") }
        }
        composable(route = "secondScreen/{name}") {
            val name = it.arguments?.getString("name") ?: "No Name"
            SecondScreen(
                name = name,
                navigateToFirstScreen = { navController.navigate("firstScreen") }
            )
        }
    }
}