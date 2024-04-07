plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.marvel"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.marvel"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.composeCompiler.get()
    }
}

dependencies {
    implementation(libs.coreKtx)
    implementation(libs.lifecycleKtx)

    implementation(platform(libs.composeBom))
    implementation(libs.composeActivity)
    implementation(libs.composeRuntime)
    implementation(libs.composeUi)
    implementation(libs.composePreview)
    implementation(libs.composeDebugPreview)
    implementation(libs.composeMaterial)
    implementation(libs.composeMaterial3)
    implementation(libs.navigation)

    implementation(libs.accompanistSystemUiController)
    implementation(libs.monitor)
    implementation(libs.coilCompose)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
}