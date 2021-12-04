package com.song.kmm.template.android.common

import android.app.Application
import androidx.annotation.CallSuper
import com.song.kmm.template.android.common.context.ContextProvider

open class BaseApplication : Application() {
    @CallSuper
    override fun onCreate() {
        super.onCreate()
        ContextProvider.setApplication(this)
    }
}