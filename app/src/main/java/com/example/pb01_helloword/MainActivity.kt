package com.example.pb01_helloword

import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pb01_helloword.ui.theme.PB01_HelloWordTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PB01_HelloWordTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(
                        text = prosesDaftarBuku(),
                        modifier = Modifier
                            .padding(16.dp)
                            .verticalScroll(rememberScrollState())
                    )
                }
            }
        }
    }
}

@Composable
fun HelloWorldScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hello, World!",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "Pemrograman Bergerak - Pertemuan 1",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HelloWorldPreview() {
    PB01_HelloWordTheme {
        HelloWorldScreen(
            modifier = Modifier.fillMaxSize()
        )
    }
}