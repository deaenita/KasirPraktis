package com.deaenita.posfinalproject

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity


data class ProductTransaction(val id: Int, val name: String, val price: Double, val imageResId: Int)
data class CartItem(val product: Product, var quantity: Int)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun POSTransaction(context: Context) {
    var totalItems by remember { mutableStateOf(0) }
    var totalPrice by remember { mutableStateOf(0.0) }

    Column {
        TopAppBar(title = { Text(text = "Transaksi") },
            contentColor = MaterialTheme.colorScheme.primary)
    }
    val productTrans = listOf(
        ProductTransaction(1, "ATS air duster 3 way", 75000.00, R.drawable.atsairdusterway),
        ProductTransaction(2, "ATS diamond cor dril 35 ml", 70000.00, R.drawable.buildingmaterials),
        ProductTransaction(3, "Aditon adibon pelengket", 65000.00, R.drawable.buildingmaterials),
        ProductTransaction(4, "Aditon pengeras", 45000.00, R.drawable.buildingmaterials),
        ProductTransaction(5, "Air keras 1 liter botol plastik HCL", 8000.00, R.drawable.buildingmaterials),
        ProductTransaction(6, "Amplas Rol", 260000.00, R.drawable.buildingmaterials),
        ProductTransaction(7, "Amplas meteran", 10000.00, R.drawable.buildingmaterials),
        ProductTransaction(8, "Amplas rol meteran", 8000.00, R.drawable.buildingmaterials),
        ProductTransaction(9, "Asgel asbes gelombang ", 58000.00, R.drawable.buildingmaterials),
        ProductTransaction(10, "Asgel asbes gelombang ", 68000.00, R.drawable.buildingmaterials),
        ProductTransaction(11, "Asgel asbes", 73000.00, R.drawable.buildingmaterials),
    )
    // Fungsi untuk menambah item ke keranjang belanja
    val addToCart: (Double, Int) -> Unit = { price, qty ->
        totalItems =+ qty
        totalPrice =+ price
    }

    var searchQuery by remember { mutableStateOf("") }
    Column {
        TopAppBar(
            title = { Text(text = "Transaksi") },
            backgroundColor = Color(0xFFD8BFD8),
            contentColor = Color.White
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
            modifier = Modifier.weight(1f)

        ) {
            items(
                count = productTrans.filter {
                    it.name.contains(searchQuery, ignoreCase = true)
                }.size
            ) { index ->
                val product = productTrans.filter {
                    it.name.contains(searchQuery, ignoreCase = true)
                }[index]

                ProductListItem(product = product) { quantity ->
                    // Update totalItems dan totalPrice ketika kuantitas berubah
                    addToCart(product.price * quantity, quantity)
                }


            }
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clip(RoundedCornerShape(8.dp))
                .clickable { /* Action when clicked */ }
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Jumlah Item: ${totalItems}",
                        fontSize = 18.sp,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "${totalPrice.toRupiahFormats()}",
                        fontSize = 18.sp
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Button(
                        onClick = {
                            val intent = Intent(context, TransaksiSukses::class.java)
                            intent.putExtra("TOTAL_ITEMS", totalItems)
                            intent.putExtra("TOTAL_PRICE", totalPrice)
                            //intent.putExtra("NAMA", totalPrice)
                            //intent.putExtra("HARGA", totalPrice)
                            context.startActivity(intent)
                        },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondary)
                    ) {
                        Text(text = "Proses Pesanan")
                    }
                }
            }

        }
    }
}

@Composable
    fun ProductListItem(product: ProductTransaction, onQuantityChange: (Int) -> Unit) {
    var jumlahProduk by remember { mutableStateOf(0) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier.clickable {
                //onItemClick(product)
            }
        ) {
            Image(
                painter = painterResource(id = product.imageResId),
                contentDescription = null,
                modifier = Modifier
                    .size(64.dp)
                    .clip(shape = RoundedCornerShape(4.dp))
            )
        }
        Spacer(modifier = Modifier.width(24.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = product.name,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = product.price.toRupiahFormats(),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.fillMaxWidth()
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {
                    if (jumlahProduk > 0) {
                        jumlahProduk--
                        onQuantityChange(jumlahProduk)

                    }
                },
                modifier = Modifier.wrapContentSize(),
                colors = ButtonDefaults.buttonColors(Color.LightGray),
            ) {
                Text("-")
            }
            Text(
                text = jumlahProduk.toString(),
                modifier = Modifier.padding(horizontal = 12.dp)
            )
            Button(
                onClick = { jumlahProduk++
                    onQuantityChange(jumlahProduk)
                },
                modifier = Modifier.wrapContentSize(),
            ) {
                Text("+")
            }
        }
    }
}



fun Double.toRupiahFormats(): String {
    val formattedValue = java.text.NumberFormat.getCurrencyInstance(java.util.Locale("id", "ID"))
        .format(this)
    return formattedValue.replace("IDR", "Rp. ")
}

class Transaction : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            POSTransaction(context = this)
        }
    }
}