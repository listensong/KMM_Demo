package com.song.kmm.template

import io.ktor.client.*

expect class Platform() {
    val platform: String
}

expect val httpClient: HttpClient