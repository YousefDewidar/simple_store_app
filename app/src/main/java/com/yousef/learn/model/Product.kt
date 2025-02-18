package com.yousef.learn.model

import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val id: Long,
    val title: String,
    val price: Double,
    val description: String,
    val rating: Rating,
    val image: String,
    val category: String,

    )

@Serializable
data class Rating(
    val rate: Double,
    val count: Long,
)
