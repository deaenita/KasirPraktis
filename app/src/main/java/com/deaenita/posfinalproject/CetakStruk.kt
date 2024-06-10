package com.deaenita.posfinalproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.deaenita.posfinalproject.ui.theme.PosFinalProjectTheme

data class StrukItem(val nama: String, val harga: Double)

@Composable
fun CetakStruks(
    items: List<StrukItem>,
    total: Double
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .padding(top = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Toko Wijaya Batu", fontSize = 20.sp, fontWeight = FontWeight.Bold,fontFamily = FontFamily.Monospace)
        Text("Jl. Dewi Sartika No.55, Temas, Kota Batu", fontSize = 14.sp,fontFamily = FontFamily.Monospace)
        Text("Senin, 27 Mei 2024 | 12:00:00", fontSize = 14.sp, fontFamily = FontFamily.Monospace)
        Spacer(modifier = Modifier.height(16.dp))
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp),
            color = MaterialTheme.colorScheme.onBackground
        )
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 1.dp),
            color = MaterialTheme.colorScheme.onBackground
        )

        Text("Struk Pembelian",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 20.dp),
            fontFamily = FontFamily.Monospace
            // Adding top margin
        )

        Spacer(modifier = Modifier.height(16.dp))

        items.forEach { item ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(item.nama, fontSize = 18.sp,fontFamily = FontFamily.Monospace)
                Text("Rp ${item.harga}", fontSize = 18.sp,fontFamily = FontFamily.Monospace)
            }
            Spacer(modifier = Modifier.height(8.dp))
        }

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            color = MaterialTheme.colorScheme.onBackground
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Total", fontSize = 18.sp, fontWeight = FontWeight.Bold,fontFamily = FontFamily.Monospace)
            Text("Rp $total", fontSize = 18.sp, fontWeight = FontWeight.Bold,fontFamily = FontFamily.Monospace)
        }

        Spacer(modifier = Modifier.height(60.dp))
        Text("Terima Kasih atas Pembelian Anda!", fontSize = 16.sp, fontWeight = FontWeight.Medium, fontFamily = FontFamily.Monospace // Mengubah font menjadi Arial
        )
    }
}

class CetakStruk : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PosFinalProjectTheme {
                val items = listOf(
                    StrukItem("Item 1", 10000.0),
                    StrukItem("Item 2", 20000.0),
                    StrukItem("Item 3", 15000.0),
                    StrukItem("Item 4", 16000.0),
                    StrukItem("Item 5", 16000.0),
                    StrukItem("Item 6", 14000.0),
                    StrukItem("Item 7", 17000.0),
                    StrukItem("Item 8", 14000.0),

                    )
                val total = items.sumOf { it.harga }
                CetakStruks(items = items, total = total)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CetakStrukPreview() {
    PosFinalProjectTheme {
        val items = listOf(
            StrukItem("Item 1", 10000.0),
            StrukItem("Item 2", 20000.0),
            StrukItem("Item 3", 15000.0)
        )
        val total = items.sumOf { it.harga }
        CetakStruks(items = items, total = total)
    }
}
