package com.example.strisakti.data.safety

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object SafetyRetrofitInstance {

    private val retrofit = Retrofit.Builder()
        // Base URL for safety API - replace with your actual API endpoint
        .baseUrl("https://api.safety-services.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: SafetyApiService = retrofit.create(SafetyApiService::class.java)
}
