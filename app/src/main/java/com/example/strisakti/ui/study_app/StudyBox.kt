package com.example.strisakti.ui.study_app

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun StudyBox(
    title: String,
    icon: String,
    showClock: Boolean = false,
    onClick: () -> Unit
) {
    // Real-time clock state
    val time = remember { mutableStateOf("") }

    // Update every second
    LaunchedEffect(Unit) {
        while (true) {
            time.value = SimpleDateFormat("hh:mm:ss a", Locale.getDefault())
                .format(Date())
            delay(1000)
        }
    }

    Card(
        modifier = Modifier
            .size(160.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(30.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(text = icon, fontSize = 40.sp)

            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.padding(top = 8.dp)
            )

            if (showClock) {
                Text(
                    text = time.value,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(top = 6.dp)
                )
            }
        }
    }
}
