package com.example.fashionnova.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.fashionnova.Fragments.Cart_Fragment
import com.example.fashionnova.Fragments.Home_Fragment
import com.example.fashionnova.R
import com.example.fashionnova.databinding.ActivityHomeScreenBinding

class Home_Screen_Activity : AppCompatActivity() {
    private lateinit var binding : ActivityHomeScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {

            loadFragment(Home_Fragment())
        }
        binding.bottomNavigationView.setOnItemSelectedListener { NavItem ->
            when (NavItem.itemId) {
                R.id.Home_Icon -> {
                    loadFragment(Home_Fragment())
                true}
                R.id.Cart_Icon -> {
                    loadFragment(Cart_Fragment())
                    true
                }
                R.id.Heart_Icon -> {
                    // Add logic to load the desired fragment
                    true
                }
                R.id.Account_Icon -> {
                    // Add logic to load the desired fragment
                    true
                }
                else -> false
            }
        }

    }
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}