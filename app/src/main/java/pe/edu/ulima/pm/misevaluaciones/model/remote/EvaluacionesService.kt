package pe.edu.ulima.pm.misevaluaciones.model.remote

import pe.edu.ulima.pm.misevaluaciones.model.entity.Carrera
import retrofit2.Call
import retrofit2.http.GET

// https://script.google.com/macros/s/AKfycbzSBsND5zTdAd0f0X-9fuFV90dlKW5rMQz7Wua24uUD58NDi3EaNdyKE6OrFwR9-IlksQ/exec

interface EvaluacionesService {
    @GET("/macros/s/AKfycbzSBsND5zTdAd0f0X-9fuFV90dlKW5rMQz7Wua24uUD58NDi3EaNdyKE6OrFwR9-IlksQ/exec?entity=carreras")
    fun getCarreras() : Call<List<Carrera>>
}