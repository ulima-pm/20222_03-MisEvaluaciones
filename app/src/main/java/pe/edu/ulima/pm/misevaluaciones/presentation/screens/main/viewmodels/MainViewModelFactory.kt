package pe.edu.ulima.pm.misevaluaciones.presentation.screens.main.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import pe.edu.ulima.pm.misevaluaciones.presentation.screens.login.viewmodels.LoginViewModel

class MainViewModelFactory(
    val context : Context
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(context) as T
    }
}