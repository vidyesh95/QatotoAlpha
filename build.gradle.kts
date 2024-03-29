// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.com.android.application) apply false
    alias(libs.plugins.org.jetbrains.kotlin.android) apply false
    alias(libs.plugins.com.google.services) apply false
}
tasks.register<Delete>("clean") {
    delete(rootProject.layout.buildDirectory)
}
tasks.register("cleanInstallDebug") {
    dependsOn("clean", "installDebug")
}
tasks.register("cleanRun") {
    dependsOn("clean", "run")
}
