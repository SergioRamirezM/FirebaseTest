package com.example.messaggingdemo

import com.google.firebase.messaging.FirebaseMessagingService

class FCMService : FirebaseMessagingService() {

    override fun onNewToken(token: String) {}

}