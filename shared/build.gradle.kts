plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Shared Modules for Unplash iOS App"
        homepage = "Link to the Shared Module homepage"
        version = "1.0" //cocopods version
        ios.deploymentTarget = "14.1"
        podfile = project.file("../unplash-ios/Podfile")
        framework {
            baseName = "Shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                //put your multiplatform dependencies here
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}

android {
    namespace = "com.androdevjik.unplash_mobile.shared"
    compileSdk = 33
    defaultConfig {
        minSdk = 21
    }
}