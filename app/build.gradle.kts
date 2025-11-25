plugins {
    alias(libs.plugins.android.application)
    // Add this line inside the plugins block:
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.real_time_database"

    // FIXED: Changed from 35 to 36 (Required by your dependencies)
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.real_time_database"
        minSdk = 24

        // FIXED: Changed from 35 to 36
        targetSdk = 36

        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    // --- KEEP YOUR EXISTING LIBS HERE ---
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)

    // --- FIREBASE DEPENDENCIES ---
    implementation(platform("com.google.firebase:firebase-bom:34.6.0"))
    implementation("com.google.firebase:firebase-database")
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-auth")

    // Testing libs
    testImplementation(libs.junit)
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation(libs.espresso.core)
}