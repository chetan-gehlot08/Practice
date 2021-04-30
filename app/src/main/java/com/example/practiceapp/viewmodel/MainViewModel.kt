package com.example.practiceapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.practiceapp.net.ApiHelper
import com.example.practiceapp.net.Resource
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val apiHelper: ApiHelper) : ViewModel() {

    fun getProducts() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = apiHelper.getProducts()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}