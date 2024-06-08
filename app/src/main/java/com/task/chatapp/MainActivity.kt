package com.task.chatapp

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.AnticipateInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.google.firebase.FirebaseApp
import com.task.chatapp.ui.theme.ChatAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        insialsplashscreen()
        setContent {
            ChatAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }

    private fun insialsplashscreen() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
            // For Android 12 and higher, use the SplashScreen API
            installSplashScreen()
            splashScreen.setOnExitAnimationListener { splashscreenview ->
                val slideup = ObjectAnimator.ofFloat(
                    splashscreenview,
                    View.TRANSLATION_Y,
                    -splashscreenview.height.toFloat()
                )
                slideup.interpolator = AnticipateInterpolator()
                slideup.duration = 1000L
                slideup.doOnEnd {
                    splashscreenview.remove()
                }
                slideup.start()
            }

        } else {
            setTheme(R.style.Theme_ChatApp)
        }
    }
}

