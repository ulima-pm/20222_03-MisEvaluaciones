package pe.edu.ulima.pm.misevaluaciones.model.domain.repository

interface UsuariosRepository {
    suspend fun login(username : String , password : String) : Boolean
}