package com.example.kmmtramites.domain.usecase

import com.example.kmmtramites.domain.model.View
import com.example.kmmtramites.domain.repository.ViewRepository

class GetViewUseCase(private val repository: ViewRepository) {
    suspend operator fun invoke(correlativo:String,tramite:String): List<View> {
        return repository.getListView(correlativo,tramite)
    }
}