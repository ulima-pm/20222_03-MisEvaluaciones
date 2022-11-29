package pe.edu.ulima.pm.misevaluaciones.presentation.screens.login.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import pe.edu.ulima.pm.misevaluaciones.model.domain.repository.UsuariosRepository

class LoginViewModelFactory(
    private val onLoginSuccess : (String) -> Unit,
    private val usuariosRepository: UsuariosRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LoginViewModel(onLoginSuccess, usuariosRepository) as T
    }
}