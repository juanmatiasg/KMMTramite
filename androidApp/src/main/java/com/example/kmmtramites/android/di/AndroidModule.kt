package com.example.kmmtramites.android.di

import com.example.kmmtramites.android.ui.viewmodel.TramiteViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


var androidModule = module {
    viewModel{ TramiteViewModel(get()) }
}



