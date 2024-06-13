package com.example.kmmtramites.android

import android.app.Application
import com.example.kmmtramites.android.di.androidModule

import com.example.kmmtramites.di.getSharedModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class TramiteApp:Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(this@TramiteApp)
            modules(androidModule + getSharedModules())
        }
    }
}