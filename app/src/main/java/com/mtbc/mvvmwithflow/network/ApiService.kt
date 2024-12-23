package com.mtbc.mvvmwithflow.network

import com.mtbc.mvvmwithflow.model.Posts
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getPosts():List<Posts>
}