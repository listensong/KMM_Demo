package com.song.kmm.template.android.wanandroid.home

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.song.kmm.template.android.wanandroid.R
import com.song.kmm.template.android.wanandroid.api.WanApiService

class WanMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.wan_activity_main)
    }

    override fun onResume() {
        super.onResume()
        Log.e("HelloWorld", "onResume value start call")
        WanApiService.getInstance()
            .banners()
            .onSuccess {
                Log.e("HelloWorld", "onSuccess value " + it.value)
            }
            .onFailure {
                Log.e("HelloWorld", "onFailure value " + it.error.description)
            }
            .onComplete {
                Log.e("HelloWorld", "onComplete value $it")
            }
            .call(lifecycleScope)
    }
}