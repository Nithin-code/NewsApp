package com.example.newsapp.mappers

import com.example.newsapp.top_head_lines.data.HeadLinesData
import com.example.newsapp.top_head_lines.view_model.HeadLinesUIScreenState

fun HeadLinesData.toHeadLinesUIState() = HeadLinesUIScreenState(
    headLinesData = this
)

fun HeadLinesUIScreenState.toHeadLinesData() = HeadLinesData(
    status = this.headLinesData.status,
    totalResults = this.headLinesData.totalResults,
    articles = this.headLinesData.articles
)