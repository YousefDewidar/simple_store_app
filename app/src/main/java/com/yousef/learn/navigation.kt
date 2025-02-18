package com.yousef.learn


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.yousef.learn.model.Product
import com.yousef.learn.views.CartView
import com.yousef.learn.views.HomeView

@Composable
fun NavGraph(navController: NavHostController, products: List<Product>) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeView(products, navController) }
        composable("cart") { CartView(navController) }
    }
}
