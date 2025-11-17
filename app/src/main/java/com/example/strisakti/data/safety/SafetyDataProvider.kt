package com.example.strisakti.data.safety

object SafetyDataProvider {

    // Police & Safety Stations
    val lavasaSafetyPoints = listOf(
        SafetyLocation(
            name = "Lavasa Police Station",
            type = "police",
            lat = 18.4088,
            lon = 73.5069,
            phone = "+91-2141-234567"
        ),

        SafetyLocation(
            name = "Women's Safety Desk - Lavasa",
            type = "safety_desk",
            lat = 18.4090,
            lon = 73.5050,
            phone = "+91-2141-234589",
            address = "Lavasa Town Center"
        ),

        SafetyLocation(
            name = "Security Control Room",
            type = "security",
            lat = 18.4101,
            lon = 73.5047,
            phone = "+91-2141-234590"
        )
    )

    // Medical Emergency Locations (Hospitals & Clinics)
    val medicalEmergencyLocations = listOf(
        MedicalLocation(
            name = "Apollo Hospital Lavasa",
            lat = 18.4051,
            lon = 73.5078,
            phone = "+91-2141-300001"
        ),

        MedicalLocation(
            name = "Dr. Sharma's Emergency Clinic",
            lat = 18.4075,
            lon = 73.5085,
            phone = "+91-2141-456789"
        ),

        MedicalLocation(
            name = "Lavasa General Hospital",
            lat = 18.4110,
            lon = 73.5055,
            phone = "+91-2141-567890"
        ),

        MedicalLocation(
            name = "24/7 Medical Aid Center",
            lat = 18.4095,
            lon = 73.5062,
            phone = "+91-2141-678901"
        )
    )

    // Women Emergency Contacts & Helplines
    val womenEmergencyContacts = listOf(
        WomenEmergencyContact(
            name = "Women Helpline 1091",
            type = "helpline",
            phone = "1091",
            address = "24/7 National Women Helpline"
        ),

        WomenEmergencyContact(
            name = "Lavasa Women's Shelter",
            type = "shelter",
            phone = "+91-2141-111111",
            address = "Lavasa Town, Mulshi, Pune"
        ),

        WomenEmergencyContact(
            name = "Women's NGO - Adarsh Foundation",
            type = "ngo",
            phone = "+91-98765-43210",
            address = "Lavasa Community Center"
        ),

        WomenEmergencyContact(
            name = "Domestic Violence Helpline",
            type = "helpline",
            phone = "181",
            address = "National Domestic Violence Helpline"
        ),

        WomenEmergencyContact(
            name = "Lavasa Police Women Cell",
            type = "helpline",
            phone = "+91-2141-234599",
            address = "Lavasa Police Station"
        )
    )
}
