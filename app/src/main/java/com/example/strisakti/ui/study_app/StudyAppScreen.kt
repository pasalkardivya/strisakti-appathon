package com.example.strisakti.ui.study_app

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun StudyAppScreen(modifier: Modifier = Modifier, navController: NavHostController) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "📚 Study App",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(16.dp))

        // ---------- TIMER ----------
        StudyBox(
            title = "Real Time Clock",
            icon = "⏰",
            showClock = true,
            onClick = {}
        )


        // ---------- CLOCK ----------
        StudyBox(
            title = "Clock",
            icon = "🕒",
            onClick = {}
        )

        // ---------- SUBJECTS ----------
        SectionTitle("Subjects (6)")

        Grid6(
            icons = listOf("📘", "📗", "📙", "📒", "📓", "📕"),
            titles = listOf(
                "Math", "Science", "English", "History", "Computer", "Geography"
            )
        )

        // ---------- STORYBOOK ----------
        SectionTitle("Story Books (6)")

        Grid6(
            icons = listOf("📖", "📚", "📔", "📒", "📗", "📘"),
            titles = listOf(
                "Stories 1", "Stories 2", "Stories 3",
                "Stories 4", "Stories 5", "Stories 6"
            )
        )

        // ---------- PDFs ----------
        StudyBox(
            title = "PDF Library",
            icon = "📄",
            onClick = {}
        )

        // ---------- WATER BREAK ----------
        StudyBox(
            title = "Water Break Timer",
            icon = "💧",
            onClick = {}
        )
    }
}
