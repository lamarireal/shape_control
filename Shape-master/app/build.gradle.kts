import com.android.build.gradle.BaseExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("kotlin-parcelize")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.shackleton.shape"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.shackleton.shape"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Navigation
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.navigation.dynamic.features.fragment)
    androidTestImplementation(libs.androidx.navigation.testing)
    implementation(libs.androidx.navigation.compose)

    // Recycler
    implementation(libs.androidx.recyclerview)

    // Glide
    implementation(libs.glide)
    annotationProcessor(libs.compiler)

    // CardView
    implementation(libs.androidx.cardview)

    // Picasso
    implementation(libs.picasso)

    // Retrofit2
    implementation(libs.retrofit)

    // Gson
    implementation(libs.converter.gson)

    // TimelineView
    implementation("com.github.vipulasri:timelineview:1.1.5")

    // PDF Viewer
    // implementation("com.github.barteksc:android-pdf-viewer:2.8.2")
    // implementation("com.google.android.material:material:1.11.0")
    // implementation ("androidx.pdf:pdf-viewer-fragment:1.0.0-alpha08")





}