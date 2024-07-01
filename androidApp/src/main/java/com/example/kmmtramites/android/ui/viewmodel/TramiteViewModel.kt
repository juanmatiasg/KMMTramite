package com.example.kmmtramites.android.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kmmtramites.domain.model.Tramite
import com.example.kmmtramites.domain.usecase.GetTramiteUseCase
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TramiteViewModel(private val useCase: GetTramiteUseCase):ViewModel() {
    private val _photos = MutableStateFlow<List<Tramite>>(emptyList())
    val photos: StateFlow<List<Tramite>> = _photos

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

     fun fetchPhotos() {
        viewModelScope.launch(Dispatchers.IO) {
            _isLoading.value = true
            _error.value = null
            try {
                _photos.value = useCase.invoke("350336")
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _isLoading.value = false
            }
        }
    }
}