package Repository

import Retrofitpackage.ApiInterface
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.fashionnova.Models.ItemData
import com.example.fashionnova.Models.ItemDataItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Product_Repo(private val apiInterface: ApiInterface) {

    private val _allProducts = MutableLiveData<List<ItemDataItem>>()  // Change to List<ItemDataItem>

    val allProducts: LiveData<List<ItemDataItem>>
        get() = _allProducts

    private val _categoryProducts = MutableLiveData<List<ItemDataItem>>()
    val categoryProducts: LiveData<List<ItemDataItem>> get() = _categoryProducts

    fun getProduct() {
        apiInterface.getdata().enqueue(object : Callback<List<ItemDataItem>> {
            override fun onResponse(call: Call<List<ItemDataItem>>, response: Response<List<ItemDataItem>>) {
                if (response.isSuccessful) {
                    _allProducts.postValue(response.body())
                } else {
                    Log.d("the error", "Response not successful: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<List<ItemDataItem>>, t: Throwable) {
                Log.d("the error", t.toString())
            }
        })
    }
    // Method to fetch products by category
    fun getProductsByCategory(category: String) {
        apiInterface.getProductsByCategory(category).enqueue(object : Callback<List<ItemDataItem>> {
            override fun onResponse(call: Call<List<ItemDataItem>>, response: Response<List<ItemDataItem>>) {
                if (response.isSuccessful) {
                    _categoryProducts.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<List<ItemDataItem>>, t: Throwable) {
                Log.d(" catogory error", t.toString())
            }
        })
    }
}
