package com.example.kmmtramites.di

import com.example.kmmtramites.data.remote.DataSource
import com.example.kmmtramites.data.remote.TramiteService
import com.example.kmmtramites.data.repository.TramiteRepositoryImp
import com.example.kmmtramites.domain.repository.TramiteRepository
import com.example.kmmtramites.domain.usecase.GetTramiteUseCase
import org.koin.dsl.module

private val dataModule = module {
    single{ TramiteService() }
    single { DataSource(get()) }
    single<TramiteRepository> { TramiteRepositoryImp(get()) }
}


private val domainModule = module {
    single {GetTramiteUseCase(get()) }
}

private val sharedModules = listOf(domainModule, dataModule)


fun getSharedModules() = sharedModules