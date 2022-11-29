package pe.edu.ulima.pm.misevaluaciones.model.domain.repository

import pe.edu.ulima.pm.misevaluaciones.model.remote.HTTPManager

class UsuariosRepositoryImpl : UsuariosRepository {
    override suspend fun login(username: String, password: String): Boolean {
        val response = HTTPManager.instance.login(username, password)
        return response!!.msg == ""
    }
}