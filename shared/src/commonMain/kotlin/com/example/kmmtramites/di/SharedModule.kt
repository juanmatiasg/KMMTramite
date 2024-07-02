package com.example.kmmtramites.di

import com.example.kmmtramites.data.remote.DataSource
import com.example.kmmtramites.data.remote.EntidadService
import com.example.kmmtramites.data.remote.TramiteService
import com.example.kmmtramites.data.remote.ViewService
import com.example.kmmtramites.data.repository.EntidadRepositoryImpl
import com.example.kmmtramites.data.repository.TramiteRepositoryImp
import com.example.kmmtramites.data.repository.ViewRepositoryImpl
import com.example.kmmtramites.domain.repository.EntidadRepository
import com.example.kmmtramites.domain.repository.TramiteRepository
import com.example.kmmtramites.domain.repository.ViewRepository
import com.example.kmmtramites.domain.usecase.GetEntidadUseCase
import com.example.kmmtramites.domain.usecase.GetTramiteUseCase
import com.example.kmmtramites.domain.usecase.GetViewUseCase
import org.koin.dsl.module

private val dataModule = module {
    single { TramiteService() }
    single { EntidadService() }
    single { ViewService() }
    single { DataSource(get(), get(), get()) }
    single<TramiteRepository> { TramiteRepositoryImp(get()) }
    single<EntidadRepository> { EntidadRepositoryImpl(get()) }
    single<ViewRepository> { ViewRepositoryImpl(get()) }
}


private val domainModule = module {
    single { GetTramiteUseCase(get()) }
    single { GetEntidadUseCase(get()) }
    single { GetViewUseCase(get()) }
}

private val sharedModules = listOf(domainModule, dataModule)


fun getSharedModules() = sharedModules