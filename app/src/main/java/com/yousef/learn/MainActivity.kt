package com.yousef.learn

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.yousef.learn.model.repo.ProductRepo
import com.yousef.learn.model.repo.ProductRepoImpl
import com.yousef.learn.ui.theme.LearnTheme
import kotlinx.coroutines.launch
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.compose.rememberNavController
import com.yousef.learn.model.Product

class MainActivity : ComponentActivity() {
    @SuppressLint("InvalidColorHexValue")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val productRepo: ProductRepo = ProductRepoImpl()
        val productList = mutableStateListOf<Product>()

        lifecycleScope.launch {
            try {
                val products = productRepo.getProducts()
                productList.addAll(products)
            } catch (e: Exception) {
                Log.e("API_ERROR", "Failed to fetch products", e)
            }
        }

        setContent {

            val navController = rememberNavController()



            LearnTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    NavGraph(navController, productList)
//                    HomeView(productList, navController)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewProductList() {
    LearnTheme {

    }
}
