package com.example.strisakti.data.news



import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("v4/search")
    suspend fun getNews(
        @Query("q") query: String,
        @Query("lang") lang: String = "en",
        @Query("country") country: String = "in",
        @Query("apikey") apiKey: String
    ): NewsResponse
}
