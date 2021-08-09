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
include(":androidModules:unitTests")
include(":androidModules:androidTests")
include(":androidModules:common")
