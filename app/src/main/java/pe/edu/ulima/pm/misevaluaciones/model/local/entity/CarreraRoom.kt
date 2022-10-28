package pe.edu.ulima.pm.misevaluaciones.model.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "carrera")
data class CarreraRoom (
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    @ColumnInfo(name = "nombre")
    val nombre : String
)