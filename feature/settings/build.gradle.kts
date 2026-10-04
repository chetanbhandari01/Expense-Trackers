plugins {
    id("naveenapps.plugin.android.feature")
    id("naveenapps.plugin.kotlin.basic")
    id("naveenapps.plugin.compose")
    id("naveenapps.plugin.di")
}

android {
    namespace = "com.chetanbhandari.expensemanager.feature.settings"
}

dependencies {
    implementation(project(":feature:export"))
    implementation(project(":feature:filter"))
    implementation(project(":feature:reminder"))
    implementation(project(":feature:theme"))
    implementation(project(":feature:language"))
    implementation(project(":feature:about"))
}
