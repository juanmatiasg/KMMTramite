package com.example.kmmtramites

import com.example.kmmtramites.domain.model.Photo

class AndroidPlatform : Platform {
    override val name: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()


