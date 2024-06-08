// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath ("com.google.firebase:firebase-crashlytics-gradle:3.0.1")
    }

}


plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    alias(libs.plugins.googleGmsGoogleServices) apply false
    id ("com.google.dagger.hilt.android") version "2.49" apply false
    id("com.google.firebase.crashlytics") version "2.9.9" apply false

}