package com.deaenita.posfinalproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.deaenita.posfinalproject.ui.theme.PosFinalProjectTheme

data class ProdukDetail(
    val nama: String,
    val harga: String,
    val deskripsi: String,
    val gambarUri: String // Ganti dengan tipe data yang sesuai dengan URI gambar
)

@Composable
fun DetailProduk(produkDetail: ProdukDetail) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Gambar produk
        Image(
            painter = painterResource(R.drawable.sembako), // Ganti dengan gambar aktual
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(MaterialTheme.shapes.medium),
            contentScale = ContentScale.Crop
        )

        // Nama produk
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = produkDetail.nama,
            style = MaterialTheme.typography.titleLarge
        )

        // Harga
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Harga: ${produkDetail.harga}",
            style = MaterialTheme.typography.titleLarge
        )

        // Deskripsi produk
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = produkDetail.deskripsi,
            style = MaterialTheme.typography.titleLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDetailProduk() {
    val sampleProduk = ProdukDetail(
        nama = "Nama Produk",
        harga = "Rp 100.000",
        deskripsi = "Deskripsi produk yang panjang dan informatif. Deskripsi produk yang panjang dan informatif.",
        gambarUri = "sample_uri" // Ganti dengan URI gambar aktual
    )

    PosFinalProjectTheme {
        DetailProduk(produkDetail = sampleProduk)
    }
}


class DetailProduct : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val sampleProduk = ProdukDetail(
                nama = "Nama Produk",
                harga = "Rp 100.000",
                deskripsi = "Deskripsi produk yang panjang dan informatif. Deskripsi produk yang panjang dan informatif.",
                gambarUri = "sample_uri" // Ganti dengan URI gambar aktual
            )

            PosFinalProjectTheme {
                DetailProduk(produkDetail = sampleProduk)
            }
        }
    }
}

@Composable
fun POSDetailProduct(){
    Column {
        TopAppBar(title = { Text(text = "Detail Produk") })
    }
}