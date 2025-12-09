package com.example.newsapp.top_head_lines.data


data class HeadLinesData(
    val status : String,
    val totalResults : Int,
    val articles : List<Article>
)

data class Article(
    val title : String,
    val description : String,
    val urlToImage : String
)
