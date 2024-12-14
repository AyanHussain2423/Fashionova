package com.example.fashionnova.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fashionnova.Adapters.Cart_Adapter
import com.example.fashionnova.Models.ItemDataItem
import com.example.fashionnova.R
import com.example.fashionnova.databinding.FragmentCartBinding
import com.example.fashionnova.databinding.FragmentHomeBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class Cart_Fragment : Fragment() {
    private lateinit var binding : FragmentCartBinding
    private lateinit var adapter: Cart_Adapter
    private lateinit var database: FirebaseDatabase
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = binding.cartRc
        adapter = Cart_Adapter(mutableListOf())
        recyclerView.layoutManager = LinearLayoutManager(requireContext().applicationContext)
        recyclerView.adapter = adapter

        database = FirebaseDatabase.getInstance()
        auth = FirebaseAuth.getInstance()
        val userId = auth.currentUser?.uid
        Call_Cart_Values()
    }
    fun Call_Cart_Values(){
        database = FirebaseDatabase.getInstance()
        auth = FirebaseAuth.getInstance()
        val userId = auth.currentUser?.uid

        database.getReference().child("users")
            .child(userId.toString()).child("cart").get().addOnSuccessListener {
                Log.d("Cart item test",it.toString())
                val cartItems = mutableListOf<ItemDataItem>()

                for (itemSnap in it.children) {
                    Log.d("items test",itemSnap.toString())
                    val itemRetrive = itemSnap.getValue(ItemDataItem::class.java)

                    if (itemRetrive != null) {
                        cartItems.add(itemRetrive)
                    }
                    else {
                        Toast.makeText(requireContext().applicationContext,"Failed to retrieve item", Toast.LENGTH_SHORT).show()
                    }
                }
                adapter.updateItems(cartItems)
            }
            .addOnFailureListener{
                Toast.makeText(requireContext().applicationContext,"Failed to Success listener", Toast.LENGTH_SHORT).show()
            }
    }

}