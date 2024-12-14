package Retrofitpackage

import com.example.fashionnova.Models.ItemData
import com.example.fashionnova.Models.ItemDataItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("products")
    fun getdata(): Call<List<ItemDataItem>>

    @GET("products/category/{category}")
    fun getProductsByCategory(@Path("category") category: String): Call<List<ItemDataItem>>
}