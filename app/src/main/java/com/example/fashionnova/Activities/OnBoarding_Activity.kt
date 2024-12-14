package com.example.fashionnova.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fashionnova.R
import com.example.fashionnova.databinding.ActivityOnBoardingBinding

class OnBoarding_Activity : AppCompatActivity() {
    private lateinit var binding : ActivityOnBoardingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.GoToLoginButton.setOnClickListener{
            val intent = Intent(this, Login_Activity::class.java)
            startActivity(intent)
            finish()
        }
        binding.GoToSignupText.setOnClickListener{
            val intent = Intent(this, Sign_Up_Activity::class.java)
            startActivity(intent)
            finish()
        }

    }
}