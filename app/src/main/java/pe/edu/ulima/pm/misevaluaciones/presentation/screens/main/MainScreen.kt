package pe.edu.ulima.pm.misevaluaciones.presentation.screens.main

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pe.edu.ulima.pm.misevaluaciones.model.entity.Carrera
import pe.edu.ulima.pm.misevaluaciones.model.remote.HTTPManager
import pe.edu.ulima.pm.misevaluaciones.presentation.screens.main.components.ListaCarreras
import pe.edu.ulima.pm.misevaluaciones.presentation.screens.main.viewmodels.MainViewModel
import pe.edu.ulima.pm.misevaluaciones.presentation.screens.main.viewmodels.MainViewModelFactory

@Composable
fun MainScreen(
    vm : MainViewModel = viewModel(
        factory = MainViewModelFactory(LocalContext.current)
    )
) {
    LaunchedEffect(key1 = true) {
        vm.getCarreras()
    }

    ListaCarreras(carreras = vm.listaCarreras)
}