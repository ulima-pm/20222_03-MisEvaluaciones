package pe.edu.ulima.pm.misevaluaciones.presentation.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import pe.edu.ulima.pm.misevaluaciones.presentation.screens.login.LoginScreen

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LoginScreen(onLoginSuccess = guardarCredencialesLogin)
        }
    }

    val guardarCredencialesLogin : (String) -> Unit = { username : String ->
        // Guardarlo en shared preferences
        val sp = getSharedPreferences("SP_CREDENCIALES", MODE_PRIVATE)
        sp.edit().putString("USERNAME", username).commit()
    }
}