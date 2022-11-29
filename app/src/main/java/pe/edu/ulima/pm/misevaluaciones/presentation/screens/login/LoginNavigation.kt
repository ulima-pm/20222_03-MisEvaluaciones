package pe.edu.ulima.pm.misevaluaciones.presentation.screens.login

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.edu.ulima.pm.misevaluaciones.model.domain.repository.UsuariosRepository

@Composable
fun LoginNavigation(
    navController : NavHostController = rememberNavController(),
    onLoginSuccess : (String) -> Unit,
    usuariosRepository: UsuariosRepository
) {
    NavHost(
        navController = navController,
        startDestination = "registro"
    ) {
        composable("login") {
            LoginScreen(
                onLoginSuccess = onLoginSuccess,
                usuariosRepository = usuariosRepository
            )
        }
        composable("registro") {
            RegistroScreen(
                onRegistroSuccess = onLoginSuccess
            )
        }
    }
}