plugins {
    id("naveenapps.plugin.android.feature")
    id("naveenapps.plugin.kotlin.basic")
    id("naveenapps.plugin.compose")
    id("naveenapps.plugin.di")
}

android {
    namespace = "com.chetanbhandari.expensemanager.feature.export"
}

dependencies {
    implementation(project(":feature:account"))
    implementation(project(":feature:filter"))
}