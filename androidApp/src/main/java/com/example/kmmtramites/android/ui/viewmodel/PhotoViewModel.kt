package com.example.kmmtramites.android.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kmmtramites.domain.model.Photo
import com.example.kmmtramites.domain.usecase.GetPhotosUseCase

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PhotoViewModel(private val useCase: GetPhotosUseCase):ViewModel() {
    private val _photos = MutableStateFlow<List<Photo>>(emptyList())
    val photos: StateFlow<List<Photo>> = _photos

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun fetchPhotos() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            try {
                _photos.value = useCase.invoke()
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _isLoading.value = false
            }
        }
    }

}