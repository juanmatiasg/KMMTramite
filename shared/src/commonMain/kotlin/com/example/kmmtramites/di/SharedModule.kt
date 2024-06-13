package com.example.kmmtramites.di

import com.example.kmmtramites.data.remote.DataSource
import com.example.kmmtramites.data.remote.KtorApi
import com.example.kmmtramites.data.remote.PhotosService
import com.example.kmmtramites.data.repository.PhotosRepositoryImp
import com.example.kmmtramites.domain.repository.PhotosRepository
import com.example.kmmtramites.domain.usecase.GetPhotosUseCase
import org.koin.dsl.module

private val dataModule = module {
    single{ PhotosService() }
    single { DataSource(get()) }
    single<PhotosRepository> { PhotosRepositoryImp(get()) }
}


private val domainModule = module {
    single {GetPhotosUseCase(get()) }
}

private val sharedModules = listOf(domainModule, dataModule)


fun getSharedModules() = sharedModules