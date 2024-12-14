package com.example.fashionnova.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fashionnova.R
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity3 : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        FirebaseApp.initializeApp(this);
            auth = Firebase.auth

            val currentUser = auth.currentUser
            if (currentUser != null) {
                navigateToMainActivity()
            } else {
                navigateToSignUpActivity()
            }
        }

        private fun navigateToMainActivity() {
            val intent = Intent(this, Home_Screen_Activity::class.java)
            startActivity(intent)
            finish()
        }

        private fun navigateToSignUpActivity() {
            val intent = Intent(this, OnBoarding_Activity::class.java)
            startActivity(intent)
            finish()
        }
    }