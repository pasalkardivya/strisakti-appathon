package com.example.strisakti.ui.screen



import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

data class WomenAdvantage(
    val title: String,
    val description: String
)

@Composable
fun AdvantagesForWomenScreen(modifier: Modifier,navController:NavController) {

    val advantages = listOf(
        WomenAdvantage(
            "Free Education for Girls",
            "Many states offer free or discounted schooling and scholarships for girls in India."
        ),
        WomenAdvantage(
            "Reservation in Government Jobs",
            "Women get reserved seats in Government jobs, police recruitment and local government roles."
        ),
        WomenAdvantage(
            "Maternity Leave Benefits",
            "Paid maternity leave up to 26 weeks is provided under the Maternity Benefit Act."
        ),
        WomenAdvantage(
            "Free Health Checkups for Women",
            "Government hospitals provide free or subsidized health check-ups including breast and cervical cancer screening."
        ),
        WomenAdvantage(
            "Safety Helplines (1091)",
            "Women can call 1091 for emergency support, police protection and assistance."
        ),
        WomenAdvantage(
            "Government Housing Support",
            "Under PMAY, women must be joint owners — giving them long-term security and property rights."
        ),
        WomenAdvantage(
            "Subsidized Loans for Women",
            "Mudra and Stand-Up India schemes provide low interest loans to help women start businesses."
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Advantages for Women",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(advantages) { item ->
                AdvantageCard(item)
            }
        }
    }
}

@Composable
fun AdvantageCard(item: WomenAdvantage) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
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
