package com.example.kmmtramites

import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import io.ktor.client.HttpClient
import io.ktor.client.engine.ProxyBuilder
import io.ktor.client.engine.cio.CIO
import io.ktor.client.engine.http
import java.net.InetSocketAddress
import java.net.Proxy

class AndroidPlatform : Platform {
    override val name: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()

actual fun initLogger() {
    Napier.base(DebugAntilog())
}

actual fun createHttpClient(): HttpClient = HttpClient(CIO) {
    engine { https { trustManager = SslSettings.getTrustManager() } }
    applyCommonConfig()
}




