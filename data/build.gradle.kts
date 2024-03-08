import org.jetbrains.kotlin.gradle.internal.KaptGenerateStubsTask
import java.util.Properties

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
}

android {
    namespace = "dv.lux.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    flavorDimensions += "environment"
    productFlavors {

        create("dev") {
            dimension = "environment"
            val configProps = Properties()
            configProps.load(project.rootProject.file("env.dev.properties").inputStream())

            buildConfigField("String", "OUTLOOK_CLIENT_ID", configProps.getProperty("outlook.clientId"))
            buildConfigField("String", "OUTLOOK_REDIRECT_URI", configProps.getProperty("outlook.redirectUri"))
            buildConfigField("String", "OUTLOOK_SCOPE", configProps.getProperty("outlook.scope"))
            buildConfigField("String", "OUTLOOK_STATE", configProps.getProperty("outlook.state"))
        }
        create("prod") {
            dimension = "environment"
            val configProps = Properties()
            configProps.load(project.rootProject.file("env.prod.properties").inputStream())

            buildConfigField("String", "OUTLOOK_CLIENT_ID", configProps.getProperty("outlook.clientId"))
            buildConfigField("String", "OUTLOOK_REDIRECT_URI", configProps.getProperty("outlook.redirectUri"))
            buildConfigField("String", "OUTLOOK_SCOPE", configProps.getProperty("outlook.scope"))
            buildConfigField("String", "OUTLOOK_STATE", configProps.getProperty("outlook.state"))
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    android {
        buildFeatures {
            buildConfig = true
        }
    }
}

tasks.withType(KaptGenerateStubsTask::class).configureEach {
    kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // DI
    implementation("com.google.dagger:hilt-android:2.48")
    kapt("com.google.dagger:hilt-android-compiler:2.48")

    // HTTP Client
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.10.0")
    implementation("com.google.code.gson:gson:2.10")

    // Architecture
    implementation(project(":domain"))
}