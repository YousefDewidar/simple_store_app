package com.yousef.learn.model.api

import com.yousef.learn.model.Product
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getProducts(): List<Product>
}

