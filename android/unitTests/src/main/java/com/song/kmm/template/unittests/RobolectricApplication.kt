package com.song.kmm.template.unittests

import android.app.Application
import android.util.Log

/**
 *  @author HelloWorld
 *  RobolectricApplication
 */
@Suppress("unused")
class RobolectricApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Log.e("AnyHelp", "EveryWorld")
    }
}