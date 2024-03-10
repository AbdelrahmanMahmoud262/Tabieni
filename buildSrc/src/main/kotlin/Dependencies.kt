import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

object Dependencies {

    const val composeBOM = "androidx.compose:compose-bom:${Versions.composeBOM}"
    const val composeMaterial = "androidx.compose.material3:material3:${Versions.composeMaterial3}"
    const val composeUi = "androidx.compose.ui:ui"
    const val composeUiGraphics = "androidx.compose.ui:ui-graphics"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling"
    const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview"
    const val composeRuntime = "androidx.compose.runtime:runtime"

    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val hiltAgp = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"

    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val okHttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val moshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"

    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"

    const val junit = "junit:junit:${Versions.junit}"
    const val testJunit = "androidx.test.ext:junit:${Versions.testJunit}"
    const val espressoTest = "androidx.test.espresso:espresso-core:${Versions.espressoTest}"

    const val datastore = "androidx.datastore:datastore-preferences:${Versions.datastore}"

    const val coil = "io.coil-kt:coil-compose:${Versions.coil}"

}

fun DependencyHandler.compose(){
    implementation(platform(Dependencies.composeBOM))
    implementation(Dependencies.composeUi)
    implementation(Dependencies.composeRuntime)
    implementation(Dependencies.composeUiGraphics)
    implementation(Dependencies.composeUiTooling)
    implementation(Dependencies.composeMaterial)
    debugImplementation(Dependencies.composeUiToolingPreview)
}

fun DependencyHandler.coil(){
    implementation(Dependencies.coil)
}

fun DependencyHandler.datastore(){
    implementation(Dependencies.datastore)
}

fun DependencyHandler.test(){
    testImplementation(Dependencies.junit)
    androidTestImplementation(Dependencies.testJunit)
    androidTestImplementation(Dependencies.espressoTest)
}

fun DependencyHandler.room() {
    implementation(Dependencies.roomRuntime)
    implementation(Dependencies.roomKtx)
    kapt(Dependencies.roomCompiler)
}

fun DependencyHandler.retrofit() {
    implementation(Dependencies.retrofit)
    implementation(Dependencies.moshiConverter)
    implementation(Dependencies.okHttp)
    implementation(Dependencies.okHttpLoggingInterceptor)
}

fun DependencyHandler.hilt() {
    implementation(Dependencies.hiltAndroid)
    kapt(Dependencies.hiltCompiler)
}

fun DependencyHandler.domain(){
    implementation(project(":domain"))
}

fun DependencyHandler.authentication(){
    implementation(project(":presentation-auth"))
}

fun DependencyHandler.dataLocal(){
    implementation(project(":data-local"))
}

fun DependencyHandler.dataRemote(){
    implementation(project(":data-remote"))
}

fun DependencyHandler.resources(){
    implementation(project(":resources"))
}

fun DependencyHandler.base(){
    implementation(project(":presentation-base"))
}

fun DependencyHandler.check(){
    implementation(project(":presentation-check"))
}

fun DependencyHandler.main(){
    implementation(project(":presentation-main"))
}

fun DependencyHandler.dataRepository(){
    implementation(project(":data-repository"))
}

fun DependencyHandler.spinner(){
    implementation(project(":spinner"))
}