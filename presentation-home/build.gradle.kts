plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

apply<MainGradlePlugin>()

android {
    namespace = "com.tabieni.presentation_home"
}

dependencies {

    compose()
    hilt()
    resources()
    domain()
    test()
}