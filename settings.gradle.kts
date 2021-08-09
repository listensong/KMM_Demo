pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "KMM_Template"
include(":androidApp")
include(":shared")
include(":tests:unitTests")
include(":tests:androidTests")