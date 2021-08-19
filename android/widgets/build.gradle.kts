plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("plugin.serialization")
    id("kotlin-parcelize")
}

android {
    compileSdk = compile_version
    buildToolsVersion =build_tools_version
    resourcePrefix = "widgets_"

    defaultConfig {
        minSdk = min_sdk_version
        targetSdk = target_sdk_version
        // versionCode = 1
        // versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        val release by getting {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    lint {
        isCheckReleaseBuilds = false
        // Or, if you prefer, you can continue to check for errors in release builds,
        // but continue the build even when errors are found:
        isAbortOnError = false
    }
}

dependencies {
    //api fileTree(dir: "libs", include: ["*.jar"])
    implementation(project(":android_common"))

    testImplementation(project(":android_unitTests"))
    androidTestImplementation(project(":android_androidTests"))
}