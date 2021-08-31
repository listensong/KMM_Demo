package com.song.kmm.template.android.wanandroid.api

import com.song.kmm.template.httpClient
import com.song.kmm.template.network.NetworkService
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlin.jvm.JvmStatic

class WanApiService private constructor() {
    private object Holder {
        val INSTANCE = WanApiService()
    }

    companion object {
        @JvmStatic
        fun getInstance(): WanApiService = Holder.INSTANCE
    }

    fun banners(): NetworkService {
        return object : NetworkService() {
            override val requestBuilder: HttpRequestBuilder
                get() = HttpRequestBuilder().apply {
                    url("https://www.wanandroid.com/banner/json")
                    method = HttpMethod.Get
                }

            override fun getClient(): HttpClient {
                return httpClient
            }
        }
    }
}