package com.example.practiceapp.retrofit

import com.example.practiceapp.model.Product
import retrofit2.http.GET

interface ApiService {

    @GET("/products")
    suspend fun getProducts(): List<Product>
}