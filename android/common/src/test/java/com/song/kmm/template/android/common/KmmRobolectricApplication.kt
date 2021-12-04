package com.song.kmm.template.android.common

import android.app.Application
import android.util.Log
import com.song.kmm.template.android.common.context.ContextProvider

/**
 *  @author HelloWorld
 *  KmmRobolectricApplication
 */
@Suppress("unused")
class KmmRobolectricApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ContextProvider.setApplication(this)
    }
}