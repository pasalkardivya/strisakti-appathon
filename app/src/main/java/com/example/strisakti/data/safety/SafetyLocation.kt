package com.example.strisakti.data.safety

import com.google.gson.annotations.SerializedName

data class SafetyLocation(
    @SerializedName("name")
    val name: String,

    @SerializedName("type")
    val type: String,   // "police", "hospital", "medical", "women_contact"

    @SerializedName("lat")
    val lat: Double,

    @SerializedName("lon")
    val lon: Double,

    @SerializedName("phone")
    val phone: String? = null,

    @SerializedName("address")
    val address: String? = null
)

// Medical Emergency Location
data class MedicalLocation(
    @SerializedName("name")
    val name: String,

    @SerializedName("lat")
    val lat: Double,

    @SerializedName("lon")
    val lon: Double,

    @SerializedName("phone")
    val phone: String? = null
)

// Women Emergency Contact
data class WomenEmergencyContact(
    @SerializedName("name")
    val name: String,

    @SerializedName("phone")
    val phone: String,

    @SerializedName("address")
    val address: String? = null,

    @SerializedName("type")
    val type: String // "helpline", "shelter", "ngo"
)