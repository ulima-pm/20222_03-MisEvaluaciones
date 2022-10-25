package pe.edu.ulima.pm.misevaluaciones.presentation.screens.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.lifecycle.viewmodel.compose.viewModel
import pe.edu.ulima.pm.misevaluaciones.presentation.screens.login.viewmodels.LoginViewModel
import pe.edu.ulima.pm.misevaluaciones.presentation.screens.login.viewmodels.LoginViewModelFactory

@Composable
fun LoginScreen(
    onLoginSuccess : (username : String) -> Unit,
    vm : LoginViewModel = viewModel(
        factory = LoginViewModelFactory(onLoginSuccess)
    )
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        OutlinedTextField(
            value = vm.username.value,
            onValueChange = {
                vm.username.value = it
            }
        )
        OutlinedTextField(
            value = vm.password.value,
            onValueChange = {
                vm.password.value = it
            },
            visualTransformation = PasswordVisualTransformation()
        )
        Button(
            onClick = { vm.login() }
        ) {
            Text(text = "Login")
        }
    }
}