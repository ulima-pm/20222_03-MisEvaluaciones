package pe.edu.ulima.pm.misevaluaciones.model.local

import android.content.Context
import androidx.room.Room
import pe.edu.ulima.pm.misevaluaciones.model.local.entity.CarreraRoom

// Fachada
class DBManager private constructor(){
    private lateinit  var dbRoom : EvaluacionDB

    companion object {
        private var _instance : DBManager? = null
        val instance : DBManager
            get() {
                if (_instance == null) {
                    _instance = DBManager()
                }
                return _instance!!
            }
    }

    fun inicializarDB(context : Context) {
        dbRoom = Room
            .databaseBuilder(
                context,
                EvaluacionDB::class.java,
                "evaluaciondb")
            .build()
    }

    fun insertCarrera(carrera : CarreraRoom) {
        dbRoom.carreraDAO().insert(carrera)
    }

    fun getCarreras() : List<CarreraRoom> {
        return dbRoom.carreraDAO().getAll()
    }
}