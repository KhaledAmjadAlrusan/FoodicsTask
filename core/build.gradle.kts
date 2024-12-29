plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    kotlin("plugin.serialization")
}

android {
    namespace = "com.foodics.core"
    compileSdk = 35

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)




    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)


    implementation (libs.androidx.lifecycle.viewmodel.compose)

    // Koin
    implementation (libs.koin.android)


    // Ktor
    implementation (libs.ktor.client.android)
    implementation (libs.ktor.serilization.kotlinx)
    implementation (libs.ktor.client.negotiation)



    // Serialization
    implementation (libs.kotlinx.serialization.json)

}