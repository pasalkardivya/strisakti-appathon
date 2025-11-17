package com.example.strisakti.data.safety


import retrofit2.http.GET
import retrofit2.http.Query

interface SafetyApiService {

    // Police & Safety Stations
    @GET("v1/nearby")
    suspend fun getNearbySafetyPlaces(
        @Query("type") type: String,
        @Query("lat") lat: Double = 18.4050,   // Lavasa
        @Query("lon") lon: Double = 73.5060    // Lavasa
    ): List<SafetyLocation>

    // Medical Emergency Locations (Hospitals, Clinics)
    @GET("v1/medical")
    suspend fun getNearbyMedicalEmergency(
        @Query("lat") lat: Double = 18.4050,
        @Query("lon") lon: Double = 73.5060
    ): List<MedicalLocation>

    // Women Emergency Contacts & Helplines
    @GET("v1/women-contacts")
    suspend fun getWomenEmergencyContacts(
        @Query("region") region: String = "india"
    ): List<WomenEmergencyContact>
}
