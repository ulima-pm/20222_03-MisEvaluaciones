package pe.edu.ulima.pm.misevaluaciones

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.*
import pe.edu.ulima.pm.misevaluaciones.presentation.screens.main.MainScreen
import pe.edu.ulima.pm.misevaluaciones.ui.theme.MisEvaluacionesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val countState = remember {
                mutableStateOf(0)
            }

            val timer = {
                var cont = 0
                while (cont < 30) {
                    Log.i("MainActivity", cont.toString())
                    countState.value = cont
                    cont += 1
                    Thread.sleep(1000L)
                }
            }

            MainScreen(countState.value) {
                GlobalScope.launch(Dispatchers.Main) {
                    withContext(Dispatchers.IO) {
                        timer()
                    }
                    finish()
                }
            }
        }
    }
}
