package com.example.strisakti.ui.screen



import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController

data class WomenScheme(
    val title: String,
    val description: String
)

@Composable
fun StartForWomenScreen(modifier: Modifier, navController: NavController) {

    val schemes = listOf(
        WomenScheme(
            "Mudra Loan for Women",
            "Government provides ₹50,000 to ₹10 lakh loan for women starting small businesses."
        ),
        WomenScheme(
            "Udyam Sakhi Portal",
            "A platform that helps women learn business skills and connect with resources."
        ),
        WomenScheme(
            "Stand-Up India",
            "Bank loans between ₹10 lakh to ₹1 crore for women entrepreneurs."
        ),
        WomenScheme(
            "Mahila Shakti Kendra",
            "Skill development + support for rural women to start working."
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Start For Women",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(schemes) { scheme ->
                WomenSchemeCard(scheme)
            }
        }
    }
}

@Composable
fun WomenSchemeCard(item: WomenScheme) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            Text(
                text = item.title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(text = item.description)
        }
    }
}
