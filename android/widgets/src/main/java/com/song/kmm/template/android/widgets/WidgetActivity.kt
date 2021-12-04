package com.song.kmm.template.android.widgets

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext

class WidgetActivity : AppCompatActivity() {
    var jobNew: Job? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.widgets_activity_widget)
        FullScreenDialog.getInstance().show(supportFragmentManager)
//        jobNew = SafeCoroutineScope(Dispatchers.Main).launch {
//            Log.e("HelloWorld", "WidgetActivity " + this.coroutineContext)
//            // throw RuntimeException("JHejpjpaowief")
//            // delay(60000)
//            repeat(1000) {
//                Log.e("HelloWorld", "WidgetActivity action " + it)
//                delay(1000)
//            }
//            Log.e("HelloWorld", "WidgetActivity Done ")
//        }
//
//        GlobalScope.launch {
//            Log.e("HelloWorld", "GlobalScope " + this.coroutineContext)
//            // throw RuntimeException("JHejpjpaowief")
//            // delay(60000)
//            repeat(1000) {
//                Log.e("HelloWorld", "GlobalScope action " + it)
//                delay(1000)
//            }
//            Log.e("HelloWorld", "GlobalScope Done ")
//        }
//
//        jobNew?.invokeOnCompletion {
//            Log.e("HelloWorld", "WidgetActivity invokeOnCompletion")
//        }
    }

    override fun onDestroy() {
        Log.e(
            "HelloWorld",
            "WidgetActivity onDestroy " + jobNew?.isActive + " -> " + jobNew?.isCancelled + " ->" + jobNew?.isCompleted
        )
        super.onDestroy()
    }
}

@Suppress("unused")
class SafeCoroutineScope(
    context: CoroutineContext,
    error: ((Throwable) -> Unit)? = null
) : CoroutineScope, Cloneable {
    override val coroutineContext: CoroutineContext =
        SupervisorJob() + context + UncaughtCoroutineExceptionHandler(error)

    override fun clone() {
        coroutineContext.cancelChildren()
    }
}

class UncaughtCoroutineExceptionHandler(
    private val errorHandler: ((Throwable) -> Unit)? = null
) : CoroutineExceptionHandler, AbstractCoroutineContextElement(CoroutineExceptionHandler.Key) {
    override fun handleException(context: CoroutineContext, exception: Throwable) {
        errorHandler?.invoke(exception)
    }
}