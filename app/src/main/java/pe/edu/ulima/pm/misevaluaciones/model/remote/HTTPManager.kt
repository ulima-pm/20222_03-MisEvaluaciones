package pe.edu.ulima.pm.misevaluaciones.model.remote

import pe.edu.ulima.pm.misevaluaciones.model.entity.Carrera
import pe.edu.ulima.pm.misevaluaciones.model.entity.LoginResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Fachada
class HTTPManager {
    private var evaluacionesService : EvaluacionesService

    init {
        // Inicializar mi objeto retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl("https://script.google.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        evaluacionesService = retrofit.create(EvaluacionesService::class.java)
    }

    companion object {
        private var _instance : HTTPManager? = null
        val instance : HTTPManager
            get() {
                if (_instance == null) {
                    _instance = HTTPManager()
                }
                return _instance!!
            }
    }

    fun getCarreras() : List<Carrera>? {
        val listaCarreras = evaluacionesService.getCarreras().execute().body()

        return listaCarreras
    }

    fun login(cod : String, pass : String) : LoginResponse? {
        return evaluacionesService.login(cod, pass).execute().body()
    }
}







