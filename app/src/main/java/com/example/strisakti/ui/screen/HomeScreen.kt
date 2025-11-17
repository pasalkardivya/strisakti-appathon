package com.example.strisakti.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val options = listOf(
        "New Updates",
        "Start for Women",
        "Law for Women",
        "Advantages for Women"
    )
    Column(
        modifier
    ) {
        LazyVerticalGrid(columns = GridCells.Adaptive(200.dp)) {
            items(options) {option ->
                Button({}) {
                    Text(option)
                }
            }
        }
    }
}