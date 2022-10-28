package pe.edu.ulima.pm.misevaluaciones.model.local

import androidx.room.Database
import androidx.room.RoomDatabase
import pe.edu.ulima.pm.misevaluaciones.model.local.dao.CarreraRoomDAO
import pe.edu.ulima.pm.misevaluaciones.model.local.entity.CarreraRoom

@Database(
    version = 1,
    entities = [CarreraRoom::class]
)
abstract class EvaluacionDB : RoomDatabase() {
    abstract fun carreraDAO() : CarreraRoomDAO
}