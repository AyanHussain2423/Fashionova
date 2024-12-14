package com.example.fashionnova.Fragments

import Repository.Product_Repo
import Retrofitpackage.ApiInterface
import Retrofitpackage.ApiUtility
import Viewmodels.Product_Viewmodel
import Viewmodels.Viewmodel_facory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.fashionnova.Adapters.Items_Adpater
import com.example.fashionnova.Models.ItemDataItem
import com.example.fashionnova.databinding.FragmentHomeBinding

class Home_Fragment : Fragment() {
    private lateinit var adapters: Items_Adpater
    private lateinit var mlist: MutableList<ItemDataItem>
    private lateinit var viewmodel: Product_Viewmodel
    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mlist = mutableListOf()
        adapters = Items_Adpater(mutableListOf())
        binding.itemRc.setHasFixedSize(false)
        binding.itemRc.adapter = adapters
        binding.itemRc.layoutManager = GridLayoutManager(
            requireContext().applicationContext,2)

        val apiInterface = ApiUtility.getinstance().create(ApiInterface::class.java)
        val productRepository = Product_Repo(apiInterface)

        viewmodel = ViewModelProvider(this, Viewmodel_facory(productRepository))
            .get(Product_Viewmodel::class.java)

        viewmodel.Product.observe(viewLifecycleOwner, Observer{ adapters.Setdata(it) })

        binding.AllProductsButton.setOnClickListener{
            adapters.clear()
            viewmodel.Product.observe(viewLifecycleOwner, Observer{ adapters.Setdata(it) })
            binding.AllProductsButton.setBackgroundColor(ContextCompat.getColor(requireContext(), android.R.color.black))
            binding.MenProductButton.setBackgroundColor(ContextCompat.getColor(requireContext(), android.R.color.white))
            binding.WomensProductButton.setBackgroundColor(ContextCompat.getColor(requireContext(), android.R.color.white))
            binding.ElectricProductButton.setBackgroundColor(ContextCompat.getColor(requireContext(), android.R.color.white))
            binding.JwelleryProductButton.setBackgroundColor(ContextCompat.getColor(requireContext(), android.R.color.white))

        }
        binding.MenProductButton.setOnClickListener {
            adapters.clear()
            viewmodel.fetchProductsByCategory("men's clothing")
            viewmodel.categoryProducts.observe(viewLifecycleOwner, Observer { products ->
                adapters.Setdata(products)})
            viewmodel.Product.observe(viewLifecycleOwner, Observer{ adapters.Setdata(it) })
            binding.AllProductsButton.setBackgroundColor(ContextCompat.getColor(requireContext(), android.R.color.white))
            binding.MenProductButton.setBackgroundColor(ContextCompat.getColor(requireContext(), android.R.color.black))
            binding.WomensProductButton.setBackgroundColor(ContextCompat.getColor(requireContext(), android.R.color.white))
            binding.ElectricProductButton.setBackgroundColor(ContextCompat.getColor(requireContext(), android.R.color.white))
            binding.JwelleryProductButton.setBackgroundColor(ContextCompat.getColor(requireContext(), android.R.color.white))

        }
        binding.WomensProductButton.setOnClickListener {
            adapters.clear()
            viewmodel.fetchProductsByCategory("women's clothing")
            viewmodel.categoryProducts.observe(viewLifecycleOwner, Observer { products ->
                adapters.Setdata(products)})
            viewmodel.Product.observe(viewLifecycleOwner, Observer{ adapters.Setdata(it) })
            binding.AllProductsButton.setBackgroundColor(ContextCompat.getColor(requireContext(), android.R.color.white))
            binding.MenProductButton.setBackgroundColor(ContextCompat.getColor(requireContext(), android.R.color.white))
            binding.WomensProductButton.setBackgroundColor(ContextCompat.getColor(requireContext(), android.R.color.black))
            binding.ElectricProductButton.setBackgroundColor(ContextCompat.getColor(requireContext(), android.R.color.white))
            binding.JwelleryProductButton.setBackgroundColor(ContextCompat.getColor(requireContext(), android.R.color.white))

        }
        binding.ElectricProductButton.setOnClickListener {
            adapters.clear()
            viewmodel.fetchProductsByCategory("electronics")
            viewmodel.categoryProducts.observe(viewLifecycleOwner, Observer { products ->
                adapters.Setdata(products)})
            binding.AllProductsButton.setBackgroundColor(ContextCompat.getColor(requireContext(), android.R.color.white))
            binding.MenProductButton.setBackgroundColor(ContextCompat.getColor(requireContext(), android.R.color.white))
            binding.WomensProductButton.setBackgroundColor(ContextCompat.getColor(requireContext(), android.R.color.white))
            binding.ElectricProductButton.setBackgroundColor(ContextCompat.getColor(requireContext(), android.R.color.black))
            binding.JwelleryProductButton.setBackgroundColor(ContextCompat.getColor(requireContext(), android.R.color.white))

        }
        binding.JwelleryProductButton.setOnClickListener {
            adapters.clear()
            viewmodel.fetchProductsByCategory("jewelery")
            viewmodel.categoryProducts.observe(viewLifecycleOwner, Observer { products ->
                adapters.Setdata(products)})
            binding.AllProductsButton.setBackgroundColor(ContextCompat.getColor(requireContext(), android.R.color.white))
            binding.MenProductButton.setBackgroundColor(ContextCompat.getColor(requireContext(), android.R.color.white))
            binding.WomensProductButton.setBackgroundColor(ContextCompat.getColor(requireContext(), android.R.color.white))
            binding.ElectricProductButton.setBackgroundColor(ContextCompat.getColor(requireContext(), android.R.color.white))
            binding.JwelleryProductButton.setBackgroundColor(ContextCompat.getColor(requireContext(), android.R.color.black))

        }
    }
}