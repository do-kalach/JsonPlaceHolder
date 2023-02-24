package com.example.jsonplaceholder

sealed class NetworkResult<out R> {

    data class Success<out T>(val data: T) : NetworkResult<T>()
    data class Error(val errorCode: Int) : NetworkResult<Nothing>()
    data class Throw(val error: Throwable) : NetworkResult<Nothing>()
    object Loading : NetworkResult<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[code=$errorCode]"
            is Throw -> throw error
            Loading -> "Loading"
        }
    }
}

fun <T> NetworkResult<T>.result(
    onSuccess: (data: T) -> Unit,
    onError: (errorCode: Int) -> Unit,
    onLoading: () -> Unit
) {
    when (this) {
        is NetworkResult.Success -> {
            onSuccess(this.data)
        }
        is NetworkResult.Error -> {
            onError(this.errorCode)
        }
        is NetworkResult.Throw -> {
            throw this.error
        }
        is NetworkResult.Loading -> {
            onLoading()
        }
    }
}