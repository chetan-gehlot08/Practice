package com.example.practiceapp.net

import com.example.practiceapp.retrofit.ApiService

class ApiHelper(private val apiService: ApiService) {

    suspend fun getProducts() = apiService.getProducts()
}