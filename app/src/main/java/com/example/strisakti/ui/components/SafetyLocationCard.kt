package com.example.strisakti.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.strisakti.data.safety.SafetyLocation
import com.example.strisakti.data.safety.MedicalLocation
import com.example.strisakti.data.safety.WomenEmergencyContact

@Composable
fun SafetyLocationCard(item: SafetyLocation) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "🚨 ${item.name}",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.height(6.dp))

            Text("Type: ${item.type}", fontSize = 13.sp)
            Text("Latitude: ${String.format("%.4f", item.lat)}", fontSize = 12.sp)
            Text("Longitude: ${String.format("%.4f", item.lon)}", fontSize = 12.sp)

            if (!item.phone.isNullOrEmpty()) {
                Text("Phone: ${item.phone}", fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
            }

            if (!item.address.isNullOrEmpty()) {
                Text("Address: ${item.address}", fontSize = 12.sp)
            }
        }
    }
}

@Composable
fun MedicalLocationCard(item: MedicalLocation) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "🏥 ${item.name}",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.height(6.dp))

            Text("Latitude: ${String.format("%.4f", item.lat)}", fontSize = 12.sp)
            Text("Longitude: ${String.format("%.4f", item.lon)}", fontSize = 12.sp)

            if (!item.phone.isNullOrEmpty()) {
                Text("Phone: ${item.phone}", fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
            }
        }
    }
}

@Composable
fun WomenContactCard(item: WomenEmergencyContact) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "📞 ${item.name}",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.height(6.dp))

            Text("Type: ${item.type}", fontSize = 13.sp)
            Text("Phone: ${item.phone}", fontSize = 12.sp, fontWeight = FontWeight.SemiBold)

            if (!item.address.isNullOrEmpty()) {
                Text("Address: ${item.address}", fontSize = 12.sp)
            }
        }
    }
}

