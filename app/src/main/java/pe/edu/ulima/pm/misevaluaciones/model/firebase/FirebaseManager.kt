package pe.edu.ulima.pm.misevaluaciones.model.firebase

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

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

    fun getCarreras() {
        db.collection("carreras")
            .get()
            .addOnSuccessListener { documents ->
                documents.forEach { doc ->
                    Log.i(
                        "Firebase", "ID:${doc.id} NOMBRE:${doc.data["nombre"]}"
                    )
                }

            }.addOnFailureListener { exception ->
                Log.e("Firebase Error", exception.message!!)
            }
    }
}










