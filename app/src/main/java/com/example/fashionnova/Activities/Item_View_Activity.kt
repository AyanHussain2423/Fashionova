package com.example.fashionnova.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.fashionnova.Models.ItemDataItem
import com.example.fashionnova.R
import com.example.fashionnova.databinding.ActivityItemViewBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class Item_View_Activity : AppCompatActivity() {
    lateinit var binding: ActivityItemViewBinding
    var firebaseAuth = FirebaseAuth.getInstance()
    private lateinit var database: FirebaseDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItemViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var auth = firebaseAuth
        val item = intent.getParcelableExtra("item") as? ItemDataItem
        var itemid = item!!.id.toString()

        database = FirebaseDatabase.getInstance()
        item?.let {
            Glide.with(this)
                .load(it.image)
                .apply(RequestOptions().transform(RoundedCorners(20)))
                .into(binding.ItemImage)
            binding.ItemName.text = it.title
            binding.ItemCatogory.text = it.category
            binding.ItemDescription.text = it.description

            val btn_text = binding.AddToCartButton.text.toString()
            binding.AddToCartButton.text = btn_text + " ${it.price}"
        }
        binding.backButton.setOnClickListener{
            finish()
        }
        binding.AddToCartButton.setOnClickListener{
            val userId = auth.currentUser?.uid
            if (userId != null) {
                database.getReference()
                    .child("users")
                    .child(userId).child("cart").child(itemid)
                    .setValue(item)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Item Added To Cart", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this, "Failed to add item to cart", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
            else {
                // Handle case when the user is not authenticated
                Toast.makeText(this, "User is not authenticated", Toast.LENGTH_SHORT).show()
            }
        }
    }
}