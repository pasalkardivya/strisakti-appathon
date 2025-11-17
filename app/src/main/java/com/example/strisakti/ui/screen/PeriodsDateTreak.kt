package com.example.strisakti.ui.screen




import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import java.time.LocalDate
import java.time.YearMonth

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PeriodsDateTreak(
    modifier: Modifier = Modifier,
    navController: NavController? = null
) {
    // Use immutable set in state so Compose notices changes
    var selectedDates by remember { mutableStateOf(setOf<LocalDate>()) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("🌸 Period Tracker") },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFFFFC1E3))
            )
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {

            Text(
                text = "💖 Track your cycle with ease",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFFD81B60)
            )

            Spacer(modifier = Modifier.height(16.dp))

            val year = LocalDate.now().year

            // Use LazyColumn for performance
            LazyColumn {
                items((1..12).toList()) { month ->
                    val ym = YearMonth.of(year, month)
                    PrettyMonthCalendar(
                        yearMonth = ym,
                        selectedDates = selectedDates,
                        onDateClick = { date ->
                            // Immutable update: assign a new set to trigger recomposition
                            selectedDates = if (selectedDates.contains(date)) {
                                selectedDates - date
                            } else {
                                selectedDates + date
                            }
                        }
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
        }
    }
}

@Composable
fun PrettyMonthCalendar(
    yearMonth: YearMonth,
    selectedDates: Set<LocalDate>,
    onDateClick: (LocalDate) -> Unit
) {
    val monthEmoji = listOf(
        "❄️", "💗", "🌸", "🌷", "🌼", "🌞",
        "🏖️", "🌤️", "🍁", "🎃", "🍂", "🎄"
    )
    val emoji = monthEmoji[yearMonth.monthValue - 1]

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFFEEF6), shape = MaterialTheme.shapes.medium)
            .padding(12.dp)
    ) {
        Text(
            text = "$emoji  ${yearMonth.month} ${yearMonth.year}",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFD81B60)
        )

        Spacer(modifier = Modifier.height(12.dp))

        val daysInMonth = yearMonth.lengthOfMonth()
        val firstDay = yearMonth.atDay(1).dayOfWeek.value % 7

        val dates = (1..firstDay).map { null } + (1..daysInMonth).map { yearMonth.atDay(it) }

        LazyVerticalGrid(
            columns = GridCells.Fixed(7),
            modifier = Modifier
                .fillMaxWidth()
                .height(290.dp)
        ) {
            items(dates) { date ->
                if (date == null) {
                    Box(modifier = Modifier.size(35.dp))
                } else {
                    val isSelected = date in selectedDates

                    Card(
                        modifier = Modifier
                            .padding(4.dp)
                            .size(45.dp)
                            .clickable { onDateClick(date) },
                        colors = CardDefaults.cardColors(
                            containerColor = if (isSelected) Color(0xFFFF7396) else Color.White
                        ),
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            if (isSelected) {
                                // shows emoji + day when selected
                                Text(text = "❤️\n${date.dayOfMonth}", fontSize = 14.sp, color = Color.White)
                            } else {
                                Text(text = date.dayOfMonth.toString(), fontSize = 16.sp, color = Color(0xFFD81B60))
                            }
                        }
                    }
                }
            }
        }
    }
}
