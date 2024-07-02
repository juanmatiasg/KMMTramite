package com.example.kmmtramites.android.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kmmtramites.domain.model.View
import com.example.kmmtramites.domain.usecase.GetViewUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ViewViewModel(private val useCase:GetViewUseCase): ViewModel() {
    private val _view = MutableStateFlow<List<View>>(emptyList())
    val view: StateFlow<List<View>> = _view

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun fetchViews(correlativo:String,tramite:String) {
        viewModelScope.launch(Dispatchers.IO) {
            _isLoading.value = true
            _error.value = null
            try {
                _view.value = useCase.invoke(correlativo, tramite)
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _isLoading.value = false
            }
        }
    }
}