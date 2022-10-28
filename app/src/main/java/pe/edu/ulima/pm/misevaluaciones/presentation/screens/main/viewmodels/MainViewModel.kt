package pe.edu.ulima.pm.misevaluaciones.presentation.screens.main.viewmodels

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pe.edu.ulima.pm.misevaluaciones.model.entity.Carrera
import pe.edu.ulima.pm.misevaluaciones.model.local.DBManager
import pe.edu.ulima.pm.misevaluaciones.model.local.entity.CarreraRoom
import pe.edu.ulima.pm.misevaluaciones.model.remote.HTTPManager

class MainViewModel(
    val context : Context
) : ViewModel() {
    val listaCarreras  = mutableStateListOf<Carrera>()

    fun getCarreras() {
        // Preguntar: Es la primera vez? -> SharedPreference (flag)
        // Si: Consulta el servicio externo (retrofit) y guarda local (room)
        // No: Consulta local (room)
        val sp = context.applicationContext.getSharedPreferences(
            "SP_INFO", Context.MODE_PRIVATE
        )
        val esPrimeraVez =
            sp.getBoolean("FLAG_ES_PRIMERA_VEZ", true)

        val dbManager = DBManager.instance
        dbManager.inicializarDB(context)

        if (esPrimeraVez){
            // Llamada Remota
            viewModelScope.launch {
                val lista = withContext(Dispatchers.IO) {
                    HTTPManager.instance.getCarreras()
                }

                if (lista != null) {
                    lista.forEach {
                        dbManager.insertCarrera(
                            CarreraRoom(
                                id = it.id,
                                nombre = it.nombre
                            )
                        )
                        listaCarreras.add(it)
                    }
                    sp.edit().putBoolean("FLAG_ES_PRIMERA_VEZ", false).commit()
                }else {
                    Log.e("MainScren", "Error de comunicacion con el servicio")
                }
            }
        }else {
            // Carga de Room
            dbManager.getCarreras().forEach {
                listaCarreras.add(
                    Carrera(
                        id = it.id,
                        nombre = it.nombre
                    )
                )
            }
        }


    }
}