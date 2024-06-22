plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.googleGmsGoogleServices)
    id ("kotlin-kapt")//Room
    id ("dagger.hilt.android.plugin")   //dagger_hilt
    id ("com.google.dagger.hilt.android")
    id("com.google.firebase.crashlytics")
    id("kotlin-parcelize")

}

android {
    namespace = "com.task.chatapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.task.chatapp"
        minSdk = 23
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

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.firebase.firestore)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    //firebase
    implementation(platform("com.google.firebase:firebase-bom:32.8.1"))
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-crashlytics")
    implementation("com.google.firebase:firebase-firestore-ktx")
    implementation("com.google.firebase:firebase-functions-ktx")
    implementation("com.google.firebase:firebase-auth-ktx")


    //Splash Api
    implementation ("androidx.core:core-splashscreen:1.0.1")


    //Compose Navigation
    val nav_version = "2.7.6"
    implementation ("androidx.navigation:navigation-compose:$nav_version")

    //Dagger Hilt
    implementation ("com.google.dagger:hilt-android:2.48")
    kapt ("com.google.dagger:hilt-android-compiler:2.48")
    kapt ("androidx.hilt:hilt-compiler:1.1.0")
    implementation ("androidx.hilt:hilt-navigation-compose:1.1.0")
    implementation ("androidx.activity:activity-ktx:1.8.1")


    //recaptcha
    implementation("com.google.android.gms:play-services-safetynet:18.0.1")


    //Coil
    implementation("io.coil-kt:coil-compose:2.4.0")

    //Accompanist
    implementation ("com.google.accompanist:accompanist-systemuicontroller:0.32.0")

    //Room
    val room_version = "2.6.1"
    implementation ("androidx.room:room-runtime:$room_version")
    kapt ("androidx.room:room-compiler:$room_version")
    implementation ("androidx.room:room-ktx:2.6.1")

    //datastore
    implementation ("androidx.datastore:datastore-preferences:1.0.0")

    //observe as state
    implementation ("androidx.compose.runtime:runtime-livedata:1.6.0")

}