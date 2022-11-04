package pe.edu.ulima.pm.misevaluaciones

import android.os.Bundle
import android.util.Log
import android.widget.Toast
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
import pe.edu.ulima.pm.misevaluaciones.model.firebase.FirebaseManager
import pe.edu.ulima.pm.misevaluaciones.model.remote.HTTPManager
import pe.edu.ulima.pm.misevaluaciones.presentation.screens.main.MainScreen
import pe.edu.ulima.pm.misevaluaciones.ui.theme.MisEvaluacionesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        FirebaseManager.instance.getCarreras()

        /*GlobalScope.launch {
            // Voy a realizar la conexion
            val httpManager = HTTPManager.instance
            val listaCarreras = withContext(Dispatchers.IO) {
                httpManager.getCarreras()
            }
            if (listaCarreras != null) {
                Log.i("MainActivity", listaCarreras.size.toString())
            }else {
                Log.e("MainActivity", "Error en el servicio");
            }
        }*/

        setContent {
            MainScreen()
        }
    }
}
