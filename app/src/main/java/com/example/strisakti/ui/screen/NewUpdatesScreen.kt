package com.example.strisakti.ui.screen



import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.example.strisakti.data.news.Article
import com.example.strisakti.data.news.RetrofitInstance
import kotlin.collections.emptyList

data class WomenUpdate(
    val title: String,
    val description: String
)

@Composable
fun NewUpdatesScreen(modifier: Modifier = Modifier, navController: NavController) {
    var updates by remember { mutableStateOf<List<Article>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }
    LaunchedEffect(true) {
        try {
            val response = RetrofitInstance.api.getNews(
                query = "industry",
                apiKey = "345f319e15bed0742d88a5daf36addc2"
            )
            updates = response.articles
            Log.d("NewsAPI", "Fetched ${updates.size} articles")
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            isLoading = false
        }
    }

//    val updates = listOf(
//        WomenUpdate(
//            "Government launches new scheme for women entrepreneurs",
//            "A new financial assistance program has been introduced to support women-owned startups."
//        ),
//        WomenUpdate(
//            "Free Skill Training for Women Announced",
//            "The Ministry of Women and Child Development offers free training in digital skills."
//        ),
//        WomenUpdate(
//            "New Workplace Safety Rules for Women",
//            "Companies must follow updated guidelines to ensure safety during late shifts."
//        ),
//        WomenUpdate(
//            "Discounted Solo Travel Packages for Women",
//            "Leading travel companies now offer 30% discounts for verified solo women travellers."
//        )
//    )

    if (isLoading) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            Text(
                text = "Women's New Updates",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(updates) { item ->
                    UpdateCard(item.title, item.description ?: "No content")
                }
            }
        }
    }
}

@Composable
fun UpdateCard(title: String, description: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(description)
        }
    }
}

