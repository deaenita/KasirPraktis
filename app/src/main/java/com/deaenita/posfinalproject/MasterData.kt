package com.deaenita.posfinalproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import java.text.NumberFormat
import java.util.Locale

data class Product(val id: Int, val name: String, val price: Double, val imageResId: Int)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun POSMasterData() {
    Column {
        TopAppBar(title = { Text(text = "Master Data") },
            contentColor = MaterialTheme.colorScheme.primary)
    }
    val products = listOf(
        Product(1, "Beras", 15.000, R.drawable.beras),
        Product(2, "Telur", 27.000, R.drawable.telur),
        Product(3, "Cabai", 50.000, R.drawable.cabai),
        Product(4, "Tomat", 5.000, R.drawable.tomato),
        Product(4, "Bawang", 10.000, R.drawable.onion),
        // ...tambahkan produk lain jika diperlukan
    )

    var searchQuery by remember { mutableStateOf("") }

    Column {
        TopAppBar(
            title = { Text(text = "Master Data") },
            backgroundColor = Color.White, // Atur warna latar belakang app bar
            contentColor = Color.Black // Atur warna teks app bar
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Kotak pencarian
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            label = { Text("Cari") },
            placeholder = { Text("Cari produk...") },
            singleLine = true,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon",
                    tint = Color.Gray
                )
            }
        )

        Spacer(modifier = Modifier.height(16.dp))


        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(
                count = products.filter {
                    it.name.contains(searchQuery, ignoreCase = true)
                }.size
            ) { index ->
                val product = products.filter {
                    it.name.contains(searchQuery, ignoreCase = true)
                }[index]
                ProductListItem(product = product)
            }
        }
    }
}

@Composable
fun ProductListItem(product: Product) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Image(
            painter = painterResource(id = product.imageResId),
            contentDescription = null,
            modifier = Modifier
                .size(64.dp)
                .clip(shape = RoundedCornerShape(4.dp))
        )

        Spacer(modifier = Modifier.width(16.dp))

        Row {
            Text(text = product.name, style = MaterialTheme.typography.labelLarge)
            Text(text = "              Rp${product.price}", style = MaterialTheme.typography.labelLarge,
                modifier = Modifier)
        }

        Spacer(modifier = Modifier.weight(1f))
    }

}

@Composable
fun MasterDataScreen() {
    // ...

    // Boolean untuk menunjukkan apakah tombol tambah ditekan
    var isAddingProduct by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End
    ) {
        FloatingActionButton(
            onClick = { isAddingProduct = true },
            modifier = Modifier
                .padding(16.dp)
                .padding(end = 30.dp)
                .padding(bottom = 20.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add Product",
                modifier = Modifier.size(24.dp)
            )
        }

        // Show dialog ketika tombol tambah ditekan
        if (isAddingProduct) {
            // ... (Tampilkan dialog atau navigasi ke layar penambahan produk)
        }
    }
}


class MasterData : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            POSMasterData()
            MasterDataScreen()
        }
    }
}