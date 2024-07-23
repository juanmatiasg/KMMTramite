package com.example.kmmtramites
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import io.ktor.client.HttpClient
import platform.UIKit.UIDevice
import io.ktor.client.engine.darwin.Darwin


class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatform(): Platform = IOSPlatform()

actual fun initLogger() { Napier.base(DebugAntilog()) }

actual fun createHttpClient(): HttpClient = HttpClient(Darwin) {
    applyCommonConfig()
}

