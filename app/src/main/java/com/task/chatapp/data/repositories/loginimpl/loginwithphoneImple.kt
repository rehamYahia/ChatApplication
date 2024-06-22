package com.task.chatapp.data.repositories.loginimpl

import android.app.Activity
import android.util.Log
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import com.google.android.gms.safetynet.SafetyNet
import com.google.android.gms.safetynet.SafetyNetApi
import com.google.android.gms.tasks.Task
import com.google.android.gms.tasks.Tasks
import com.google.firebase.FirebaseException
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.firestore.FirebaseFirestore
import com.task.chatapp.MainActivity
import com.task.chatapp.data.models.Resource
import com.task.chatapp.data.models.loginmodel.userlogin
import com.task.chatapp.domain.repositories.login.LoginWithPhone
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class loginwithphoneImple @Inject constructor(
    private val firestore: FirebaseFirestore,
    private val auth: FirebaseAuth
):LoginWithPhone {






    override fun loginWithPhone(phone: String, activity: Activity?): Flow<Resource<userlogin>> =
        flow {
            try {



                if (activity == null) {
                    emit(Resource.Error(Exception("Activity is null")))
                    return@flow
                }

                emit(Resource.Loading())



                // Initialize reCAPTCHA
                val siteKey = initializeReCaptcha()

                // Verify reCAPTCHA
                val reCaptchaToken = verifyReCaptcha(siteKey, activity)


                val options = PhoneAuthOptions.newBuilder(auth)
                    .setPhoneNumber(phone)
                    .setTimeout(60L, TimeUnit.SECONDS)
                    .setActivity(activity)
                    .setCallbacks(object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                        override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                            suspend {
                                try {
                                    signInWithCredential(credential)
                                } catch (e: Exception) {
                                    emit(Resource.Error(Exception(e)))
                                }
                            }
                        }

                        override fun onVerificationFailed(p0: FirebaseException) {
                            suspend {
                                emit(Resource.Error((Exception(p0))))
                            }

                        }


                        override fun onCodeSent(
                            verificationId: String,
                            token: PhoneAuthProvider.ForceResendingToken
                        ) {
                            super.onCodeSent(verificationId, token)
                            val verificationcode = verificationId
                            val Token = token

                            Log.d("AuthRepository", "Code sent: $verificationcode,$Token")

                            Log.d("reCaptchaToken", reCaptchaToken.toString())


                        }
                    })
                    .build()
                PhoneAuthProvider.verifyPhoneNumber(options)

            } catch (e: Exception) {

                Log.d("login_error", e.toString())
                emit(Resource.Error(Exception(e)))
            }


        }

    override suspend fun verifymycode(verificationId: String, code: String) {
        val credential = PhoneAuthProvider.getCredential(verificationId, code)
        signInWithCredential(credential)
    }

    private val executor: Executor = Executors.newCachedThreadPool()

    suspend fun verifyReCaptcha(siteKey: String, activity: Activity) {
        val task: Task<SafetyNetApi.RecaptchaTokenResponse> = SafetyNet.getClient(activity)
            .verifyWithRecaptcha(siteKey)

        try {
            val result = Tasks.await(task)
            if (result != null) {
                result.tokenResult.toString()
            } else {
                // Handle verification failure
                Log.e("AuthRepository", "reCAPTCHA verification failed")
                ""
            }
        } catch (e: Exception) {
            // Handle exception
            Log.e("AuthRepository", "reCAPTCHA verification exception: ${e.message}")

        }

    }


    fun initializeReCaptcha(): String {
        // Initialize reCAPTCHA and return the site key
        // Replace "YOUR_RECAPTCHA_SITE_KEY" with your actual reCAPTCHA site key
        return "6LeGuv4pAAAAAImJSJ3E3l0vDdKiyXyJtLJ_4Yc3"
    }


    suspend fun signInWithCredential(credential: PhoneAuthCredential) {
        try {
            val result = auth.signInWithCredential(credential).await()
            val userId = result.user?.uid ?: throw Exception("UserID not found")
            val userLogin = userlogin(phonenumber = credential.smsCode ?: "", id = userId, profilePictureUrl = "", username = "", status = true )
            firestore.collection("users").document(userId).set(userLogin).await()
            Log.d("user",userId)
            Resource.Success((userLogin))

        }
        catch (e: Exception) {
            Resource.Error((Exception(e)))
        }
    }


//    suspend fun verifymycode(verificationId: String, code: String) {
//        val credential = PhoneAuthProvider.getCredential(verificationId, code)
//        signInWithCredential(credential)
//    }





}