package com.deaenita.posfinalproject.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deaenita.posfinalproject.Product
import com.deaenita.posfinalproject.api.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONArray

class MasterDataViewModel : ViewModel() {
    private val repository = ProductRepository()



    // Function to get data from the repository
    fun getProducts(onSuccess: (List<Product>) -> Unit, onError: (String) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
//                val response = repository.getProducts() // Mengambil respons dari API
//                val jsonArray = JSONArray(response) // Mengubah respons menjadi JSON array
//                val products = mutableListOf<Product>()

                // Mengurai setiap objek dalam array JSON menjadi objek Product
//                for (i in 0 until jsonArray.length()) {
//                    val jsonObject = jsonArray.getJSONObject(i)
//                    val id = jsonObject.getInt("id")
//                    val name = jsonObject.getString("name")
//                    val price = jsonObject.getDouble("price")
//                    val imageResId = jsonObject.getInt("imageResId")
//                    products.add(Product(id, name, price, imageResId))
//                }

//                Log.d("produksss", "Products successfully retrieved: $products")
//                onSuccess(products)
            } catch (e: Exception) {
                val errorMessage = e.message ?: "Unknown error"
                Log.e("MasterDataViewModel", "Error retrieving products: $errorMessage")
                onError(errorMessage)
            }
        }
    }
}