package screens.commons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

class Field(
    private val type: Type
) {

    enum class Type(val color: Color) {
        PATHWAY(Color.Green),
        WALL(Color.Gray),
        EXIT(Color.Green),
        COIN(Color.Yellow)
    }

    @Composable
    fun draw() {
        Box(Modifier.fillMaxHeight().aspectRatio(1f).background(type.color))
    }
}