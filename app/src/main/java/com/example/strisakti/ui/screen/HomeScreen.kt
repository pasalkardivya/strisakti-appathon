// filepath: c:\Users\Pradnya Pasalkar\AndroidStudioProjects\strisakti\app\src\main\java\com\example\strisakti\ui\screen\HomeScreen.kt
package com.example.strisakti.ui.screen
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
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

    // BEAUTIFUL GRADIENT BACKGROUND
    val gradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFFFFD1DC),   // Light Pink
            Color(0xFFFFA3B1),   // Sweet Pink
            Color(0xFFFF7C9E)    // Bold Pink
        )
    )

    Column(
        modifier
            .fillMaxSize()
            .background(gradient)
            .padding(16.dp)
    ) {

        // Attractive Title
        Text(
            text = "Women's Safety App",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        // GRID MENU
        LazyVerticalGrid(columns = GridCells.Adaptive(180.dp)) {
            items(options) { option ->
                Card(
                    modifier = Modifier
                        .padding(12.dp)
                        .height(150.dp)
                        .clickable { navController.navigate(option.route) },
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(10.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White.copy(alpha = 0.9f)
                    )
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = option.displayText,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFE91E63) // Pink Accent
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
