package com.song.kmm.template.unittests

import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.Signature
import androidx.test.core.app.ApplicationProvider
import org.robolectric.Shadows

object PackageUtils {
    @JvmStatic
    fun installPackage(packageName: String, versionCode: Int) {
        val signatures = arrayOf(Signature(byteArrayOf()))
        val packageInfo = PackageInfo()
        packageInfo.signatures = signatures
        packageInfo.packageName = packageName
        packageInfo.versionCode = versionCode
        val packageManager =
            Shadows.shadowOf(ApplicationProvider.getApplicationContext<Context>().packageManager)
        packageManager.installPackage(packageInfo)
    }

    @JvmStatic
    fun installPackage(packageName: String, versionCode: Int, versionName: String) {
        val signatures = arrayOf(Signature(byteArrayOf()))
        val packageInfo = PackageInfo()
        packageInfo.signatures = signatures
        packageInfo.packageName = packageName
        packageInfo.versionCode = versionCode
        packageInfo.versionName = versionName
        val packageManager =
            Shadows.shadowOf(ApplicationProvider.getApplicationContext<Context>().packageManager)
        packageManager.installPackage(packageInfo)
    }
}