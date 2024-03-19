package screens.singlePlayer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.lifecycle.LifecycleEffect
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import screens.commons.Field

class SinglePlayerScreen : Screen {

    private val score = mutableStateOf(0)
    private val collectedCoins = mutableStateOf(0)
    private val timeLeft = mutableStateOf(10)
    private val isCounterActive = mutableStateOf(false)
    private val mazeFields = mutableStateOf(emptyList<List<Field>>())

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current

        LifecycleEffect(
            onStarted = { onStarted() }
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Time: ${timeLeft.value}")
            Text("Score: ${score.value}")
            Text("Collected coins:  ${collectedCoins.value}")
            Maze()
        }
    }

    @Composable
    private fun Maze() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            for (fieldRow in mazeFields.value) {
                Row(
                    modifier = Modifier.fillMaxWidth().aspectRatio(mazeFields.value.size.toFloat())
                ) {
                    for (field in fieldRow) {
                        field.draw()
                    }
                }
            }
        }
    }

    private fun onStarted() {
        generateMaze()

        CoroutineScope(Dispatchers.Main).launch {
            while (true) {
                if(isCounterActive.value) {
                    timeLeft.value -= 1
                    delay(1000)
                } else {
                    delay(100)
                }
            }
        }
    }

    private fun generateMaze() {
        val mazeWidth = 9;
        val mazeHeight = 9;

        val newMazeMentalMap = ArrayList<ArrayList<Field.Type>>()
        


        val newMaze = ArrayList<ArrayList<Field>>()
        for (i in 1..mazeHeight) {
            val newRow = ArrayList<Field>()

            for (j in 1..mazeWidth) {
                newRow.add(Field(newMazeMentalMap[i][j]))
            }
            newMaze.add(newRow)
        }

        mazeFields.value = newMaze
    }
}