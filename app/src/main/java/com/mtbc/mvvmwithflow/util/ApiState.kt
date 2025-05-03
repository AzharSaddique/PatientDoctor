package com.mtbc.mvvmwithflow.util


sealed class ApiState<out T> {
    object Idle : ApiState<Nothing>()
    object Loading : ApiState<Nothing>()
    data class Success<out T>(val data: T) : ApiState<T>()
    data class Error<out T>(val exception: Throwable) : ApiState<T>()
}