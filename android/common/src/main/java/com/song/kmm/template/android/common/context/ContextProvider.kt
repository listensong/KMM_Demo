package com.song.kmm.template.android.common.context

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class ContextProvider {
    companion object {
        @SuppressLint("StaticFieldLeak")
        private var sContext: Context? = null
        private var sApplication: Application? = null

        @JvmStatic
        fun setApplicationContext(context: Context) {
            sContext = context
        }

        @Suppress("unused")
        @JvmStatic
        fun getApplicationContext(): Context {
            return sContext ?: sApplication?.applicationContext!!
        }

        @JvmStatic
        fun setApplication(application: Application) {
            sApplication = application
            if (sContext == null) {
                sContext = application.applicationContext
            }
        }

        @Suppress("unused")
        @JvmStatic
        fun getApplication(): Application {
            return sApplication!!
        }
    }
}