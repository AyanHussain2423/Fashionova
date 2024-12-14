package Retrofitpackage

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiUtility {
    val BASE_URL = "https://fakestoreapi.com/"

    fun getinstance() : Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}