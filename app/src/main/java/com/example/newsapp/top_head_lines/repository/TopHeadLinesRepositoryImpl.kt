package com.example.newsapp.top_head_lines.repository

import com.example.newsapp.network.client.EndPoint
import com.example.newsapp.network.response.DataError
import com.example.newsapp.network.response.NetworkResponse
import com.example.newsapp.top_head_lines.data.HeadLinesData
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url

class TopHeadLinesRepositoryImpl(
    val client: HttpClient
) : TopHeadLinesRepository {

    override suspend fun getTopHeadLines(): NetworkResponse<HeadLinesData, DataError> {
        return try {
            val serviceResponse = client.get {
                url(EndPoint.TOP_HEADLINES_END_POINT)
                url {
                    parameters.append("apiKey", EndPoint.API_KEY)
                    parameters.append("country", "us")
                }
            }

            val body = serviceResponse.body<HeadLinesData>()

            NetworkResponse.Success(data = body)

        } catch (t: Exception) {
            NetworkResponse.Error(error = t.message.toString())
        }


    }
}