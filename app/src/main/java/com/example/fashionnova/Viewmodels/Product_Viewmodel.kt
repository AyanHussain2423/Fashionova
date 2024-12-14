package Viewmodels

import Repository.Product_Repo
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fashionnova.Models.ItemData
import com.example.fashionnova.Models.ItemDataItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Product_Viewmodel(private val productRepo: Product_Repo) : ViewModel() {
    val Product: LiveData<List<ItemDataItem>> =
        productRepo.allProducts  // Make sure this is List<ItemDataItem>

    init {
        viewModelScope.launch(Dispatchers.IO) {
            productRepo.getProduct()
        }
    }

    val categoryProducts: LiveData<List<ItemDataItem>> = productRepo.categoryProducts

    // Fetch products by category
    fun fetchProductsByCategory(category: String) {
        viewModelScope.launch(Dispatchers.IO) {
            productRepo.getProductsByCategory(category)
        }
    }
}
