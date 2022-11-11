package pe.edu.ulima.pm.misevaluaciones.presentation.screens.login.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class RegistroViewModelFactory(
    private val onLoginSuccess : (String) -> Unit
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return RegistroViewModel(onLoginSuccess) as T
    }
}