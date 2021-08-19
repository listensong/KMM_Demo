package com.song.kmm.template.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.song.kmm.template.android.R
import com.song.kmm.template.android.widgets.WidgetActivity
import com.song.kmm.template.network.test.BaiduApiService

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startActivity(Intent(this, WidgetActivity::class.java))
    }

    override fun onResume() {
        super.onResume()
//        BaiduApiService.getInstance().baiduService()
//            .onSuccess {
//                Log.e("HelloWorld", "onSuccess " + it.value)
//            }
//            .onFailure {
//                Log.e("HelloWorld", "onFailure " + it.error.description)
//            }
//            .onComplete {
//                Log.e("HelloWorld", "onComplete $it")
//            }
//            .call(timeoutMillis = 10000)
    }
}