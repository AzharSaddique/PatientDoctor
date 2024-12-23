package com.mtbc.mvvmwithflow.Repository

import com.mtbc.mvvmwithflow.model.Posts
import com.mtbc.mvvmwithflow.network.ApiAServiceImpl
import com.mtbc.mvvmwithflow.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiServiceImpl: ApiAServiceImpl) {

    suspend fun getPosts():Flow<List<Posts>> = flow {
        emit(apiServiceImpl.getPosts())
    }.flowOn(Dispatchers.IO)
}