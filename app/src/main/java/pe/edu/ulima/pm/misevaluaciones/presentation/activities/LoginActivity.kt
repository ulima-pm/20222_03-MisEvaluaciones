package pe.edu.ulima.pm.misevaluaciones.presentation.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import pe.edu.ulima.pm.misevaluaciones.MainActivity
import pe.edu.ulima.pm.misevaluaciones.presentation.screens.login.LoginNavigation
import pe.edu.ulima.pm.misevaluaciones.presentation.screens.login.LoginScreen

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Consultar el SharedPreferences
        val username = obtenerCredencialesLogin()
        if (username != null && username != "") {
            // No es la primera vez (ya me loguie antes)
            pasarAlMain()
        }else {
            setContent {
                LoginNavigation(
                    onLoginSuccess = guardarCredencialesLogin
                )
            }
        }
    }

    val guardarCredencialesLogin : (String) -> Unit = { username : String ->
        // Guardarlo en shared preferences
        val sp = getSharedPreferences("SP_CREDENCIALES", MODE_PRIVATE)
        sp.edit().putString("USERNAME", username).commit()

        pasarAlMain()
    }

    private fun pasarAlMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    val obtenerCredencialesLogin : () -> String? = {
        val sp = getSharedPreferences("SP_CREDENCIALES", MODE_PRIVATE)
        val username = sp.getString("USERNAME", "")
        username
    }
}