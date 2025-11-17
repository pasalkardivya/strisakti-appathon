package com.example.strisakti.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LawForWomen(modifier: Modifier,navController: NavController) {

    val lawList = listOf(
        LawItem(
            "Domestic Violence Act",
            "Protection of Women from Domestic Violence Act, 2005",
            "Provides protection from physical, emotional, verbal, sexual, and economic abuse."
        ),
        LawItem(
            "Dowry Prohibition Act",
            "Dowry Prohibition Act, 1961",
            "This law prohibits giving or taking dowry at the time of marriage."
        ),
        LawItem(
            "Sexual Harassment Act",
            "Sexual Harassment of Women at Workplace Act, 2013",
            "Ensures every woman has the right to a safe workplace environment."
        ),
        LawItem(
            "Maternity Benefit Act",
            "Maternity Benefit (Amendment) Act, 2017",
            "Provides 26 weeks paid maternity leave for women employees."
        ),
        LawItem(
            "Right to Equal Pay",
            "Equal Remuneration Act, 1976",
            "Women must be paid equal wages for equal work."
        ),
        LawItem(
            "Right to Education",
            "Free & Compulsory Education Act",
            "Ensures girls have equal right to schooling and safety in schools."
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("⚖️ Laws & Rights for Women") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFE1BEE7)
                )
            )
        }
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {

            items(lawList.size) { index ->
                LawCard(lawList[index])
                Spacer(Modifier.height(12.dp))
            }
        }
    }
}

@Composable
fun LawCard(item: LawItem) {

    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { expanded = !expanded },
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFCE4EC)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {

        Column(modifier = Modifier.padding(16.dp)) {

            Text(
                text = "📜 ${item.title}",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFD81B60)
            )

            Text(
                text = item.subtitle,
                fontSize = 15.sp,
                color = Color(0xFF880E4F)
            )

            Spacer(Modifier.height(10.dp))

            if (expanded) {
                Text(
                    text = item.description,
                    fontSize = 16.sp,
                    color = Color.Black
                )

                Spacer(Modifier.height(8.dp))
                Text(
                    text = "Tap to hide ▲",
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            } else {
                Text(
                    text = "Tap to expand ▼",
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }
        }
    }
}

data class LawItem(
    val title: String,
    val subtitle: String,
    val description: String
)
