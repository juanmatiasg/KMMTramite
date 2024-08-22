@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    kotlin("plugin.serialization") version "2.0.0"
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }


    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()

    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        val ktor_version="2.0.0"
        val koin_version ="3.4.0"

        commonMain.dependencies {

            //Ktor
            implementation("io.ktor:ktor-client-core:$ktor_version")
            implementation("io.ktor:ktor-client-cio:$ktor_version")
            implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")
            implementation("io.ktor:ktor-client-content-negotiation:$ktor_version")
            implementation("io.ktor:ktor-client-logging:$ktor_version")


            //Napier
            implementation("io.github.aakira:napier:2.7.1")

            //Dependency injection
            implementation("io.insert-koin:koin-core:${koin_version}")

        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }

        androidMain.dependencies {
            //KTOR
            implementation("io.ktor:ktor-client-okhttp:$ktor_version")
            implementation("io.ktor:ktor-client-android:$ktor_version")
            api("io.insert-koin:koin-android:$koin_version")
        }

        iosMain.dependencies {
            implementation("io.ktor:ktor-client-darwin:$ktor_version")
        }


    }
}

android {
    namespace = "com.example.kmmtramites"
    compileSdk = 34
    defaultConfig {
        minSdk = 30

    }
}
