package com.deaenita.posfinalproject

import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

data class Produk(val nama: String, val harga: String, val stok: String, val deskripsi: String, val gambarUri: Uri?)

@Composable
fun TambahProduk(onSave: (Produk) -> Unit, onCancel: () -> Unit) {
    var nama by remember { mutableStateOf("") }
    var harga by remember { mutableStateOf("") }
    var stok by remember { mutableStateOf("") }
    var deskripsi by remember { mutableStateOf("") }
    var gambarUri by remember { mutableStateOf<Uri?>(null) }

    Column(modifier = Modifier.fillMaxSize()) {
        // Input gambar
        Button(onClick = {
            // Buka file picker untuk memilih gambar
            // Simpan URI gambar yang dipilih ke dalam variabel gambarUri
        }) {
            Text("Pilih Gambar")
        }
        gambarUri?.let { uri ->
            Text("File terpilih: $uri")
        }

        // Input nama
        TextField(
            value = nama,
            onValueChange = { nama = it },
            label = { Text("Nama") }
        )

        // Input harga
        TextField(
            value = harga,
            onValueChange = { harga = it },
            label = { Text("Harga") }
        )

        // Input stok
        TextField(
            value = stok,
            onValueChange = { stok = it },
            label = { Text("Stok") }
        )

        // Input deskripsi
        TextField(
            value = deskripsi,
            onValueChange = { deskripsi = it },
            label = { Text("Deskripsi") }
        )

        // Button simpan
        Button(
            onClick = { onSave(Produk(nama, harga, stok, deskripsi, gambarUri)) }
        ) {
            Text("Simpan")
        }

        // Button batal
        Button(
            onClick = onCancel
        ) {
            Text("Batal")
        }
    }
}