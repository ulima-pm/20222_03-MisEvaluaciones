package pe.edu.ulima.pm.misevaluaciones.presentation.screens.login.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import pe.edu.ulima.pm.misevaluaciones.model.firebase.FirebaseManager

class RegistroViewModel(
    private val onRegistroSuccess : (String) -> Unit,
) : ViewModel() {
    val name = mutableStateOf("")
    val username = mutableStateOf("")
    val password = mutableStateOf("")

    fun registrarFirebase() {
        FirebaseManager.instance.registrarUsuario(
            name = name.value,
            username = username.value,
            password = password.value,
            onError = { msg ->
                Log.e("ERROR", msg)
            }
        ) { name ->
            onRegistroSuccess(name)
        }
    }
}