package com.deaenita.posfinalproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

class Qr : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            POSQr()
        }
    }
}

@Composable
fun POSQr(){
    Column {
        TopAppBar(title = { Text(text = "QR") })
    }
}



//Button(
//onClick = { /* Tindakan saat tombol tambah ditekan */ },
//modifier = Modifier
//.height(40.dp)
//.padding(horizontal = 16.dp),
//colors = ButtonDefaults.buttonColors(Color.Blue)
//) {
//    Text(text = "Add", color = Color.White)
//}