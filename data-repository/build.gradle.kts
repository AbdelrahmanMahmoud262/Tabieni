plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

apply<MainGradlePlugin>()

android {
    namespace = "com.tabieni.data_repository"
}

dependencies {

    hilt()
    domain()
    compose()
    test()

}