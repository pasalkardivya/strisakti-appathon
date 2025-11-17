package com.example.strisakti.data.news



data class Article(
    val title: String,
    val description: String?,
    val url: String?,
    val image: String?
)

data class NewsResponse(
    val totalArticles: Int,
    val articles: List<Article>
)
