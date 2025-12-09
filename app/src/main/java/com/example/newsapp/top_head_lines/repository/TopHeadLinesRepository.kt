package com.example.newsapp.top_head_lines.repository

import com.example.newsapp.network.response.DataError
import com.example.newsapp.network.response.NetworkResponse
import com.example.newsapp.top_head_lines.data.HeadLinesData

interface TopHeadLinesRepository {

    suspend fun getTopHeadLines() : NetworkResponse<HeadLinesData, DataError>

}