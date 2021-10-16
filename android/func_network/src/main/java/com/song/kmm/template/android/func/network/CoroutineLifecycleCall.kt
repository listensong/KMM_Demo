package com.song.kmm.template.android.func.network

interface CoroutineLifecycleCall<T> {
    fun cancel()
    fun enqueue(callback: CoroutineLifecycleCallback<T>)
    fun clone(): CoroutineLifecycleCall<T>
    fun isCanceled(): Boolean
    fun enableCancel(): Boolean
}