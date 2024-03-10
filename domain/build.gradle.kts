plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

apply<MainGradlePlugin>()

android {
    namespace = "com.tabieni.domain"
}

dependencies {

    hilt()
    compose()
    test()
}