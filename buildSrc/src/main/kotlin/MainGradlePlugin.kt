import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project

class MainGradlePlugin: Plugin<Project> {

    override fun apply(project: Project) {
        applyPlugins(project)
        setProjectConfig(project)
    }

    private fun applyPlugins(project: Project){
        project.apply {
            plugin("android-library")
            plugin("kotlin-android")
            plugin("dagger.hilt.android.plugin")
            plugin("kotlin-kapt")
        }

    }

    private fun setProjectConfig(project: Project){
        project.android().apply {
            compileSdk = ProjectConfig.compileSdk

            defaultConfig{
                minSdk = ProjectConfig.minSdk
                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            }

            compileOptions{
                sourceCompatibility = JavaVersion.VERSION_18
                targetCompatibility = JavaVersion.VERSION_18
            }

            buildTypes {
                release {
                    isMinifyEnabled = false
                    proguardFiles(
                        getDefaultProguardFile("proguard-android-optimize.txt"),
                        "proguard-rules.pro"
                    )
                }
            }

            buildFeatures {
                compose = true
            }
            composeOptions {
                kotlinCompilerExtensionVersion = Versions.composeCompiler
            }
        }
    }

    private fun Project.android():LibraryExtension{
        return extensions.getByType(LibraryExtension::class.java)
    }
}