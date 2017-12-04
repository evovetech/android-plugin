plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(26)

    defaultConfig {
        applicationId = "tech.evove.sample"
        minSdkVersion(21)
        targetSdkVersion(26)
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles("proguard-rules.pro")
        }
    }
}

val app: groovy.util.Expando by extra
val kotlinVersion = app.getProperty("kotlinVersion")!!

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jre7:${kotlinVersion}")
    implementation("com.android.support:appcompat-v7:26.1.0")
    implementation("com.android.support:design:26.1.0")
    implementation("com.android.support.constraint:constraint-layout:1.0.2")
    testImplementation("junit:junit:4.12")
    androidTestImplementation("com.android.support.test:runner:1.0.1")
    androidTestImplementation("com.android.support.test.espresso:espresso-core:3.0.1")
}
