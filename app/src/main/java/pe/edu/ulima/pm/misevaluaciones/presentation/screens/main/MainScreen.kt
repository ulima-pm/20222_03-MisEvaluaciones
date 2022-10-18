package pe.edu.ulima.pm.misevaluaciones.presentation.screens.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun MainScreen(
    count : Int,
    startTimer : () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            onClick = { startTimer() },
            modifier = Modifier.align(Alignment.TopCenter)
        ) {
            Text(text = "Click")
        }
        Text(
            text = count.toString(),
            modifier = Modifier.align(Alignment.Center)
        )
    }

}