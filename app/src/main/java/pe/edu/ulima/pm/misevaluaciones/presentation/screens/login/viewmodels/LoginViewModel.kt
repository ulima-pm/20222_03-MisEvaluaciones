package pe.edu.ulima.pm.misevaluaciones.presentation.screens.login.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pe.edu.ulima.pm.misevaluaciones.model.firebase.FirebaseManager
import pe.edu.ulima.pm.misevaluaciones.model.remote.HTTPManager

class LoginViewModel(
    private val onLoginSuccess : (String) -> Unit
) : ViewModel() {
    var username = mutableStateOf("")
    var password = mutableStateOf("")
    var error = mutableStateOf("")

    fun login() {
        viewModelScope.launch {
            val loginResponse = withContext(Dispatchers.IO) {
                HTTPManager.instance.login(
                    cod = username.value,
                    pass = password.value
                )
            }

            if (loginResponse != null) {
                if (loginResponse.msg == ""){
                    // Login correcto
                    onLoginSuccess(username.value)
                }else {
                    // Login incorrecto
                }
            }
        }
    }

    fun loginFirebase() {
        FirebaseManager.instance.login(
            cod = username.value,
            password = password.value,
            onError = { msg ->
                //Login Incorrecto
                error.value = msg
            }
        ) { name ->
            // Login Correcto
            onLoginSuccess(name)
        }
    }
}