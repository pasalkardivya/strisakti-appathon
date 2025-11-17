package com.example.strisakti.data.news



import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://gnews.io/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: NewsApiService = retrofit.create(NewsApiService::class.java)
}
