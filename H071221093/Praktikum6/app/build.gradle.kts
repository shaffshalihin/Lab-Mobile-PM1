plugins {
    alias(libs.plugins.androidApplication)
}

android {
    namespace = "com.example.praktikum6"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.praktikum6"
        minSdk = 30
        targetSdk = 34
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

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0") // Instal retrofit2
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0") // Instal retrofit2-converter
// OkHttp
    implementation ("com.squareup.okhttp3:okhttp:4.9.1") // Instal okhttp (caching, logging, dll)
    implementation ("com.squareup.picasso:picasso:2.71828") // Instal picasso (Menampilkan gambar)
}