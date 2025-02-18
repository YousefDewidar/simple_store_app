package com.yousef.learn.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.yousef.learn.model.Product

@Composable
fun ProductItem(
    product: Product,
    inCart: Boolean,
) {
    Box(
        modifier = Modifier
            .padding(5.dp, 0.dp, 5.dp, 8.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White)
            .height(100.dp)

            .fillMaxWidth()
    ) {
        Row(
            Modifier.padding(10.dp)
        ) {

            AsyncImage(
                model = product.image,
                contentDescription = "",
                modifier = Modifier.size(80.dp)
            )

            Spacer(modifier = Modifier.width(10.dp))


            Column {

                Text(
                    text = product.title,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 2
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "Price: ${product.price}$", style = MaterialTheme.typography.bodyMedium)
            }
        }

        if (!inCart) {
            Button(
                onClick = {
                    productListInCart.add(product)
                },
                shape = RoundedCornerShape(8.dp, 0.dp, 8.dp, 0.dp),
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .height(38.dp),
                contentPadding = PaddingValues(8.dp, 5.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "",
                    modifier = Modifier.size(20.dp)
                )
            }
        } else
            Button(
                onClick = {
                    productListInCart.remove(product)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red
                ),
                shape = RoundedCornerShape(
                    8.dp, 0.dp, 8.dp, 0.dp
                ),
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .height(38.dp),
                contentPadding = PaddingValues(8.dp, 5.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "",
                    modifier = Modifier.size(20.dp)
                )
            }


    }


}
