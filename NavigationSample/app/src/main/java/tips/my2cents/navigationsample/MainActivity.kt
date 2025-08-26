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
            FirstScreen { name: String, age: Int -> navController.navigate("secondScreen/$name/$age") }
        }
        composable(route = "secondScreen/{name}/{age}") {
            val name = it.arguments?.getString("name") ?: "No Name"
            val age = it.arguments?.getString("age")?.toIntOrNull() ?: 0
            SecondScreen(
                name = name,
                age = age,
                navigateToFirstScreen = { navController.navigate("firstScreen") }
            )
        }
    }
}