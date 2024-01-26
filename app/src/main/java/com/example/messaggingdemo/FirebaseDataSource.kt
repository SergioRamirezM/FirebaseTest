package com.example.messaggingdemo

import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class FirebaseDataSource {
    suspend fun getCurrentToken(): String? =
        suspendCoroutine { taskResult ->
            try {
                FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
                    if (!task.isSuccessful) {
                        return@OnCompleteListener
                    }
                    val token = task.result
                    if (!token.isNullOrEmpty())
                        println("lel--->TOKEN: $token")
                    //taskResult.resume(TaskResult.Success(token))
                })
            } catch (error: Exception) {
                //taskResult.resume(TaskResult.Failure(error))
            }
        }
}