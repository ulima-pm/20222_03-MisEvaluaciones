package pe.edu.ulima.pm.misevaluaciones.model.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import pe.edu.ulima.pm.misevaluaciones.model.local.entity.CarreraRoom

@Dao
interface CarreraRoomDAO {
    @Query("SELECT * FROM carrera")
    fun getAll() : List<CarreraRoom>
    @Query("SELECT * FROM carrera WHERE id=:id")
    fun getById(id : Int) : CarreraRoom
    @Insert
    fun insert(carrera : CarreraRoom) : Unit
}