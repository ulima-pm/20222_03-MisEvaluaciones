package pe.edu.ulima.pm.misevaluaciones.presentation.screens.main.viewmodels

import android.util.Log
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pe.edu.ulima.pm.misevaluaciones.model.entity.Carrera
import pe.edu.ulima.pm.misevaluaciones.model.remote.HTTPManager

class MainViewModel : ViewModel() {
    val listaCarreras  = mutableStateListOf<Carrera>()

    fun getCarreras() {
        // Llamada Remota
        viewModelScope.launch {
            val lista = withContext(Dispatchers.IO) {
                HTTPManager.instance.getCarreras()
            }

            if (lista != null) {
                lista.forEach {
                    listaCarreras.add(it)
                }
            }else {
                Log.e("MainScren", "Error de comunicacion con el servicio")
            }
        }
    }
}