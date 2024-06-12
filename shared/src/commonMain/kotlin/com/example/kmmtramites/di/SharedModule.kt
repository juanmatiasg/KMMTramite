package com.example.kmmtramites.di

import org.koin.dsl.module

private val dataModule = module {
    //factory { RemoteDataSource(get(), get()) }
    //factory { MovieService() }
}


private val domainModule = module {
    //single<MovieRepository> { MovieRepositoryImpl(get()) }
    //factory { GetMoviesUseCase() }
    //factory { GetMovieUseCase() }
}

private val sharedModules = listOf(domainModule, dataModule)


fun getSharedModules() = sharedModules