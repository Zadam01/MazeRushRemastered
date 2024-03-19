import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.FadeTransition
import screens.mainMenu.MainMenuScreen

@Composable
fun App() {
    MaterialTheme {
        Navigator(MainMenuScreen()) { navigator ->
            FadeTransition(navigator)
        }
    }
}