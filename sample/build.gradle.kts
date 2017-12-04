plugins {
    id("com.android.application")
    kotlin("android")
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

val app = extra["app"]

dependencies {
    //    implementation(fileTree(dir = "libs", include = ["*.jar"]))
//    implementation("org.jetbrains.kotlin:kotlin-stdlib-jre7:${app.getProperty("kotlinVersion")}")
    implementation("com.android.support:appcompat-v7:26.1.0")
    implementation("com.android.support:design:26.1.0")
    implementation("com.android.support.constraint:constraint-layout:1.0.2")
    testImplementation("junit:junit:4.12")
    androidTestImplementation("com.android.support.test:runner:1.0.1")
    androidTestImplementation("com.android.support.test.espresso:espresso-core:3.0.1")
}
