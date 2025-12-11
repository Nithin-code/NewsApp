package com.example.newsapp.network.response

import coil3.network.NetworkResponseBody
import com.example.newsapp.network.client.EndPoint
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ParametersBuilder
import io.ktor.http.parameters

object MakeSafeNetworkCall {

    suspend inline fun<reified T> safeCall(
        client : HttpClient,
        url : String
    ) : NetworkResponse<T, DataError>{
        try {
            val response = client.get {
                url(url)
                url {
                    parameters.addRequiredParams()
                }
            }

            return if (response.isSuccess()){
                NetworkResponse.Success(data = response.body<T>())
            }else{
                NetworkResponse.Error(error = DataError.Remote.UNKNOWN.name)
            }
        }catch (t: Exception){
            return NetworkResponse.Error(error = t.message.toString())
        }

    }

    fun HttpResponse.isSuccess() : Boolean {
        return this.status.value == 200
    }

    fun ParametersBuilder.addRequiredParams(){
        append("apiKey", EndPoint.API_KEY)
        append("country", "us")
    }

}