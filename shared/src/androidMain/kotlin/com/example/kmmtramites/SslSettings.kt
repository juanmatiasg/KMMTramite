package com.example.kmmtramites

import android.annotation.SuppressLint
import android.content.Context
import java.io.FileNotFoundException
import java.io.InputStream
import java.security.KeyStore
import java.security.cert.CertificateFactory
import java.security.cert.X509Certificate
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManagerFactory
import javax.net.ssl.X509TrustManager


@SuppressLint("StaticFieldLeak")
object SslSettings {
    private lateinit var context: Context

    fun initialize(context: Context) {
        this.context = context
    }

    private fun getContext(): Context {
        return context ?: throw IllegalStateException("Context not initialized")
    }

    fun fileExistsInAssets(fileName: String): Boolean {
        return try {
            getContext().assets.open(fileName).use { true }
        } catch (e: FileNotFoundException) {
            false
        }
    }

    private fun getKeyStore(): KeyStore {
        val fileName = "IGJ_CertificateAndroid.cer"

        if (!fileExistsInAssets(fileName)) {
            throw FileNotFoundException("File $fileName not found in assets")
        }

        val keyStore = KeyStore.getInstance(KeyStore.getDefaultType()).apply {
            load(null, null) // Inicializa el KeyStore vacío
        }


        return keyStore
    }

    fun getTrustManagerFactory(): TrustManagerFactory {
        val trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm())
        trustManagerFactory.init(getKeyStore())
        return trustManagerFactory
    }

    fun getSslContext(): SSLContext {
        val sslContext = SSLContext.getInstance("TLS")
        sslContext.init(null, getTrustManagerFactory().trustManagers, null)
        return sslContext
    }

    fun getTrustManager(): X509TrustManager {
        return getTrustManagerFactory().trustManagers.first { it is X509TrustManager } as X509TrustManager
    }

}

