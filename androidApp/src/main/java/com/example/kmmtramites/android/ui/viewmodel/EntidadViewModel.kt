package com.example.kmmtramites.android.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kmmtramites.domain.model.Entidad
import com.example.kmmtramites.domain.model.Tramite
import com.example.kmmtramites.domain.usecase.GetEntidadUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class EntidadViewModel(private val useCase: GetEntidadUseCase): ViewModel() {

    private val _entidad = MutableStateFlow<Entidad?>(null)
    val entidad: StateFlow<Entidad?> = _entidad

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun fetchEntidadForCorrelativo(numeroCorrelativo:String) {
        viewModelScope.launch(Dispatchers.IO) {
            _isLoading.value = true
            _error.value = null
            try {
                _entidad.value = useCase.getEntidadForCorrelativo(numeroCorrelativo)
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun fetchEntidadForTramite(tramite:String) {
        viewModelScope.launch(Dispatchers.IO) {
            _isLoading.value = true
            _error.value = null
            try {
                _entidad.value = useCase.getEntidadForTramite(tramite)
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _isLoading.value = false
            }
        }
    }
}