package com.yousef.learn.views

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.yousef.learn.model.Product


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartView(navController: NavController) {

    Scaffold(
        containerColor = Color.LightGray.copy(0.1f),

        topBar = {
            TopAppBar(
                title = { Text("Cart") },

                actions = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowForward,
                            contentDescription = "back"
                        )
                    }
                }
            )


        }
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .padding(16.dp)
                .padding(padding)
        ) {
            items(productListInCart) { product ->
                ProductItem(product, true)
            }
        }
    }


}

val productListInCart = mutableStateListOf<Product>()