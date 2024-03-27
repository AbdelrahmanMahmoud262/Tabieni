import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins{
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
}

dependencies{
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.23")
    implementation("com.android.tools.build:gradle:8.3.1")
}

val compileKotlin : KotlinCompile by tasks
compileKotlin.kotlinOptions{
    jvmTarget = "18"
}