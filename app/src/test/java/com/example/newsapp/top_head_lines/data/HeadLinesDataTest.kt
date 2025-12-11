package com.example.newsapp.top_head_lines.data

import org.junit.Assert.*
import org.junit.Test

class HeadLinesDataTest {

    val articlesList = listOf<Article>(
        Article(
            title = "ABC",
            description = "ABC",
            urlToImage = null
        )
    )
    val headLinesData = HeadLinesData(
        status = "200",
        totalResults = 32,
        articles = articlesList
    )


    @Test
    fun `When Given headLines Data is not null`(){
        assertNotNull(headLinesData.status)
        assertNotNull(headLinesData.totalResults)
        assertNotNull(headLinesData.articles)
    }

}