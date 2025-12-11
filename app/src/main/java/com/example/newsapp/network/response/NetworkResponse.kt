package com.example.newsapp.network.response

sealed interface NetworkResponse<out T,out E> {

    data object Loading : NetworkResponse<Nothing, Nothing>

    data class Success<T>(val data : T) : NetworkResponse<T, Nothing>

    data class Error<E>(val error : String) : NetworkResponse<Nothing, E>

    fun getSuccessData() = (this as Success).data

    fun isSuccess() = this is Success

    fun isLoading() = this is Loading

    fun isError() = this is Error

    fun getSuccessDataOrNull() = if (this.isSuccess()) this.getSuccessData() else null

    fun getErrorMessage() = (this as Error).error

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


