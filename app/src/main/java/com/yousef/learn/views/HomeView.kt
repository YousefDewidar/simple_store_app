package com.yousef.learn.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.yousef.learn.model.Product


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(products: List<Product>, navController: NavController) {
    Scaffold(
        containerColor = Color.LightGray.copy(0.1f),
        topBar = {
            TopAppBar(
                title = { Text("Home") },

                actions = {
                    IconButton(onClick = { navController.navigate("cart") }) {
                        Icon(
                            imageVector = Icons.Default.ShoppingCart,
                            contentDescription = "السلة"
                        )
                    }
                }
            )


        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(16.dp)
                .padding(padding)
        ) {
            Text(text = "All Products", style = MaterialTheme.typography.headlineSmall)

            Spacer(modifier = Modifier.height(10.dp))

            LazyColumn {
                items(products) { product ->
                    ProductItem(product, false)
                }
            }
        }
    }

}

