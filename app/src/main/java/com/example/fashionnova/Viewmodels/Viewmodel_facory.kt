package Viewmodels

import Repository.Product_Repo
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class Viewmodel_facory(private val productRepo: Product_Repo): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(Product_Viewmodel::class.java)) {
            return Product_Viewmodel(productRepo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}