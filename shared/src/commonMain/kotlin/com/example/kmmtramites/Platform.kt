package com.example.kmmtramites

import com.example.kmmtramites.domain.model.Photo
import org.koin.core.module.Module

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

