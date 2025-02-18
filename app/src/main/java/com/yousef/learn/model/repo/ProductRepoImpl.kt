package com.yousef.learn.model.repo

import com.yousef.learn.model.Product
import com.yousef.learn.model.api.RetrofitClient

class ProductRepoImpl : ProductRepo {
    override suspend fun getProducts(): List<Product> {
        return RetrofitClient.apiService.getProducts()
    }
}