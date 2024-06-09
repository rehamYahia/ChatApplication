package com.task.chatapp

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.animation.AnticipateInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.google.firebase.FirebaseApp
import com.task.chatapp.presentaion.composables.Mynaviation
import com.task.chatapp.presentaion.composables.StartPage
import com.task.chatapp.presentaion.viewmodel.startviewmodel
import com.task.chatapp.ui.theme.ChatAppTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val viewmodel by viewModels<startviewmodel>()
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window,false)
        installSplashScreen().apply {
            setKeepOnScreenCondition{
                viewmodel.splashcondition
            }
        }
        setContent {
            ChatAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val start=viewmodel.startdistination
                    Mynaviation(start)

                }
            }
        }
    }


    private fun insialsplashscreen() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
            // For Android 12 and higher, use the SplashScreen API
            WindowCompat.setDecorFitsSystemWindows(window,false)
            installSplashScreen().apply {
                setKeepOnScreenCondition{
                    viewmodel.splashcondition
                }
            }
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

