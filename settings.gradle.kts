pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "KMM_Template"
include(":shared")

// android modules configuration
include(":androidApp")
composeSubProject("androidModules", "android_")

fun composeSubProject(subProjectDirName: String, modulePrefix: String) {
    File("./$subProjectDirName")
        .walk()
        .maxDepth(1)
        .filter {
            it.isDirectory
        }
        .filterNot {
            it.name == subProjectDirName
        }
        .filter {
            File("${it.path}${File.separator}build.gradle").isFile ||
                    File("${it.path}${File.separator}build.gradle.kts").isFile
        }
        .forEach { dir ->
            include("$modulePrefix${dir.name}")
            project(":$modulePrefix${dir.name}").projectDir = dir
        }
}
