plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

apply<MainGradlePlugin>()

android {
    namespace = "com.tabieni.presentation_plan"
}

dependencies {

    compose()
    hilt()
    resources()
    domain()
}