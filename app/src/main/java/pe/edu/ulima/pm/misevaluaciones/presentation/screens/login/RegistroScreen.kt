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
import pe.edu.ulima.pm.misevaluaciones.presentation.screens.login.viewmodels.RegistroViewModel
import pe.edu.ulima.pm.misevaluaciones.presentation.screens.login.viewmodels.RegistroViewModelFactory

@Composable
fun RegistroScreen(
    onRegistroSuccess : (String) -> Unit,
    vm : RegistroViewModel = viewModel(
        factory = RegistroViewModelFactory(onRegistroSuccess)
    )
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        OutlinedTextField(
            value = vm.name.value,
            onValueChange = {
                vm.name.value = it
            },
            label = {
                Text(text = "Ingrese nombre")
            }
        )
        OutlinedTextField(
            value = vm.username.value,
            onValueChange = {
                vm.username.value = it
            },
            label = {
                Text(text = "Ingrese username")
            }
        )
        OutlinedTextField(
            value = vm.password.value,
            onValueChange = {
                vm.password.value = it
            },
            label = {
                Text(text = "Ingrese password")
            },
            visualTransformation = PasswordVisualTransformation()
        )
        Button(
            onClick = {
                vm.registrarFirebase()
            }
        ) {
            Text(text = "Registrar")
        }
    }
}