package com.example.kmmtramites.android.di

import ConnectivityViewModel
import com.example.kmmtramites.android.ui.viewmodel.EntidadViewModel
import com.example.kmmtramites.android.ui.viewmodel.TramiteViewModel
import com.example.kmmtramites.android.ui.viewmodel.ViewViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


var androidModule = module {
    viewModel { TramiteViewModel(get()) }
    viewModel { EntidadViewModel(get()) }
    viewModel { ViewViewModel(get()) }
    viewModel{ConnectivityViewModel(get())}
}



