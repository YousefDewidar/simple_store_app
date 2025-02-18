package com.yousef.learn.model.repo

import com.yousef.learn.model.Product

interface ProductRepo {

    suspend fun getProducts(): List<Product>

}