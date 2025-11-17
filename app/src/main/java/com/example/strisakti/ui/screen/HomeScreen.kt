package com.example.strisakti.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HomeScreen(modifier: Modifier = Modifier, navController: NavController) {
    val options = listOf(
        MenuOption("New Updates", "new_updates"),
        MenuOption("Start for Women", "start_for_women"),
        MenuOption("Law for Women", "law_for_women"),
        MenuOption("Advantages for Women", "advantages_for_women"),
        MenuOption("Periods Date Track", "periods_track"),

    )

    Column(
        modifier
    )
    {
        LazyVerticalGrid(columns = GridCells.Adaptive(200.dp)) {
            items(options) { option ->
                Card(
                    modifier = Modifier
                        .padding(10.dp)
                        .size(180.dp)              // Square 180dp
                        .clickable { navController.navigate(option.route) },
                    shape = RoundedCornerShape(12.dp),
                    elevation = CardDefaults.cardElevation(8.dp)
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = option.displayText,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }

    }
}

data class MenuOption(
    val displayText: String,
    val route: String
)
