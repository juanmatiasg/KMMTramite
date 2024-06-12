package com.example.kmmtramites.android.di

import com.example.kmmtramites.android.ui.viewmodel.PhotoViewModel
import org.koin.dsl.module

var androidModule = module {
    single{ PhotoViewModel(get()) }
}