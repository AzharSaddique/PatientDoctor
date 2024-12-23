package com.mtbc.mvvmwithflow.util

import com.mtbc.mvvmwithflow.model.Posts

sealed class ApiState {
    object Loading : ApiState()
    class Failure(val msg: Throwable) : ApiState()
    class Success(val data: List<Posts>) : ApiState()
    object Empty : ApiState()
}