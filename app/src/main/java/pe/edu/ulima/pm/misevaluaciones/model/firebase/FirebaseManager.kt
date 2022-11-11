package pe.edu.ulima.pm.misevaluaciones.model.firebase

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import pe.edu.ulima.pm.misevaluaciones.model.entity.Carrera

// Singleton
class FirebaseManager private constructor(){
    val db : FirebaseFirestore

    init {
        db = Firebase.firestore
    }

    companion object {
        private var _instance : FirebaseManager? = null
        val instance : FirebaseManager
            get() {
                if (_instance == null) {
                    _instance = FirebaseManager()
                }
                return _instance!!
            }
    }

    fun getCarreras(
        callbackSuccess : (List<Carrera>) -> Unit,
        callbackError : (String) -> Unit,
    ) {
        db.collection("carreras")
            .get()
            .addOnSuccessListener { documents ->
                val lista = mutableListOf<Carrera>()
                documents.forEach { doc ->
                    lista.add(
                        Carrera(
                            id = doc.id,
                            nombre = doc.data["nombre"]!! as String
                        )
                    )
                }
                callbackSuccess(lista)

            }.addOnFailureListener { exception ->
                Log.e("Firebase Error", exception.message!!)
                callbackError(exception.message!!)
            }
    }

    fun login(
        cod : String,
        password : String,
        onError : (String) -> Unit,
        onSuccess : (String) -> Unit
    ){
        db.collection("usuarios")
            .whereEqualTo("username", cod)
            .whereEqualTo("password", password)
            .get()
            .addOnSuccessListener {  snapshot ->
                if (snapshot.size() > 0) {
                    val name = snapshot.documents[0].data!!
                        .get("nombre")!!.toString()
                    onSuccess(name)
                }else {
                    // Error en login
                    onError("Login incorrecto")
                }
            }.addOnFailureListener {
                onError(it.message.toString())
            }
    }

    fun registrarUsuario(
        name : String,
        username : String,
        password : String,
        onError : (String) -> Unit,
        onSuccess : (String) -> Unit
    ) {
        val newDoc = db.collection("usuarios").document()

        val data = HashMap<String, Any>()
        data["name"] = name
        data["username"] = username
        data["password"] = password

        newDoc.set(data)
            .addOnSuccessListener {
                onSuccess(name)
            }.addOnFailureListener { exception ->
                onError(exception.message!!.toString())
            }
    }
}










