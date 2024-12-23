package com.mtbc.mvvmwithflow.network

import com.mtbc.mvvmwithflow.model.Posts
import javax.inject.Inject

class ApiAServiceImpl @Inject constructor(private val  apiService: ApiService) {
    suspend fun getPosts():List<Posts> = apiService.getPosts()
}