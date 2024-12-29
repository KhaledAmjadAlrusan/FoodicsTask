plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    kotlin("plugin.serialization")
    id ("com.google.devtools.ksp")
}

android {
    namespace = "com.foodics.foodicstask"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.foodics.foodicstask"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
}

dependencies {
    implementation(project(":core"))
    implementation(project(":data"))
    implementation(project(":domain"))
    implementation(project(":presentation"))





    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)


    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)


    // Koin
    implementation (libs.koin.android)
    implementation (libs.koin.androidx.navigation)
    implementation (libs.koin.androidx.compose)
    implementation (libs.koin.core)
    testImplementation (libs.koin.test.junit4)
    implementation(libs.androidx.navigation.compose)


    // ViewModel
    implementation (libs.androidx.lifecycle.viewmodel.compose)


    // Ktor
    implementation (libs.ktor.client.core)
    implementation (libs.ktor.client.android)
    implementation (libs.ktor.serilization.kotlinx)
    implementation (libs.ktor.client.negotiation)
    implementation (libs.ktor.client.logging)


    // Logger
    implementation (libs.logback.classic)


    // Serialization
    implementation (libs.kotlinx.serialization.json)


    // Room
    implementation (libs.androidx.room.runtime)
    ksp (libs.androidx.room.compiler)
    annotationProcessor (libs.androidx.room.compiler)

    implementation (libs.androidx.room.ktx)
    implementation(libs.coil.compose)


}