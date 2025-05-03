package com.mtbc.mvvmwithflow.network

import com.mtbc.mvvmwithflow.loginSignup.request.SignupRequestModel
import com.mtbc.mvvmwithflow.loginSignup.response.UserLoginSignupResponse
import com.mtbc.mvvmwithflow.model.Posts
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiInterfaces {
    @GET("posts")
    suspend fun getPosts(): Response<List<Posts>>

    @POST("Users/signup")
    suspend fun signup(@Body request: SignupRequestModel): Response<UserLoginSignupResponse>

    @POST("Users/login")
    suspend fun login(
        @Query("email") email: String, @Query("password") password: String
    ): Response<UserLoginSignupResponse>
}