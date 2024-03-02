plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.chattymin.mviclonecoding"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.chattymin.mviclonecoding"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":data"))
    implementation(project(":domain"))

    // Compose
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.compose.ui.ui)
    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    // Accompanist
    implementation(libs.google.accompanist)

    // Navigation Compose
    implementation(libs.androidx.navigation)

    // Koin
    implementation(libs.io.insert.koin)

    // Orbit
    implementation(libs.orbit.mvi.core)
    implementation(libs.orbit.mvi.viewmodel)
    implementation(libs.orbit.mvi.compose)
    implementation(libs.orbit.mvi.test)

    // Coil
    implementation(libs.coil.compose)

    // Test
    implementation(libs.junit.junit)
    implementation(libs.androidx.test.junit)
    implementation(libs.androidx.test.espresso.core)
    implementation(libs.androidx.compose.ui.test.junit4)
    implementation(libs.androidx.compose.ui.tooling)
    implementation(libs.androidx.compose.ui.test.manifest)
}
