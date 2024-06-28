package com.example.kmmtramites

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

expect fun initLogger()



