package com.example.newsapp.top_head_lines.data

import kotlinx.serialization.Serializable


@Serializable
data class HeadLinesData(
    val status : String,
    val totalResults : Int,
    val articles : List<Article>
)

@Serializable
data class Article(
    val title : String = "",
    val description : String? = "",
    val urlToImage : String? = ""
)
