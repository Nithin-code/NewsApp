package com.example.newsapp.network.response

sealed interface NetworkResponse<T,E> {

    data object Loading : NetworkResponse<Nothing, Nothing>

    data class Success<T>(val data : T) : NetworkResponse<T, Nothing>

    data class Error<E>(val error : E) : NetworkResponse<Nothing, E>

}

sealed interface Error

sealed interface DataError : Error {

    enum class Remote : DataError{
        REQUEST_TIMEOUT,
        TOO_MANY_REQUESTS,
        NO_INTERNET,
        SERVER,
        SERIALIZATION,
        UNKNOWN
    }

    enum class Local : DataError{
        DISK_FULL,
        INSUFFICIENT_BALANCE,
        UNKNOWN
    }
}

