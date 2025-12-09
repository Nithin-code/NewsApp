package com.example.newsapp.top_head_lines.repository

import com.example.newsapp.network.client.EndPoint
import com.example.newsapp.network.client.KtorClient
import com.example.newsapp.network.response.DataError
import com.example.newsapp.network.response.Error
import com.example.newsapp.network.response.NetworkResponse
import com.example.newsapp.top_head_lines.data.HeadLinesData
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import okhttp3.OkHttpClient
import okhttp3.internal.connection.Exchange

class TopHeadLinesRepositoryImpl(
    val client : HttpClient
) : TopHeadLinesRepository {

    override suspend fun getTopHeadLines(): NetworkResponse<HeadLinesData, DataError> {
        return try {
            val serviceResponse = client
                .get(EndPoint.TOP_HEADLINES_END_POINT)

            val body = serviceResponse.body<HeadLinesData>()

            NetworkResponse.Success<HeadLinesData, DataError>(data = body)

        }catch (t : Exception){
           NetworkResponse.Error<HeadLinesData, DataError>(error = DataError.Remote.UNKNOWN)
        }
    }


}