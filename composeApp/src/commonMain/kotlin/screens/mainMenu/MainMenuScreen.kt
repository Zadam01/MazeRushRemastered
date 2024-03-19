package screens.mainMenu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import screens.market.MarketScreen
import screens.multiPlayer.MultiPlayerScreen
import screens.singlePlayer.SinglePlayerScreen

class MainMenuScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Maze Rush",
                fontSize = 55.sp
            )
            Spacer(
                modifier = Modifier.fillMaxSize(0.2f)
            )
            MainMenuButton(
                text = "Play",
                onClick = { navigator?.push(SinglePlayerScreen()) } )
            MainMenuButton(
                text = "Versus",
                onClick = { navigator?.push(MultiPlayerScreen()) } )
            MainMenuButton(
                text = "Market",
                onClick = { navigator?.push(MarketScreen()) }
            )
        }
    }

    @Composable
    fun MainMenuButton(text : String, onClick : () -> Unit) {
        Spacer(
            modifier = Modifier.fillMaxSize(0.025f)
        )
        Button(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .aspectRatio(3f),
            onClick = onClick
        ) {
            Text(
                text = text,
                fontSize = 20.sp
            )
        }
    }
}