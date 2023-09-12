package com.androdevjik.unplash_mobile.shared

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform