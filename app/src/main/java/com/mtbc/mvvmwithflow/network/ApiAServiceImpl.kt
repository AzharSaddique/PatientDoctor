package com.mtbc.mvvmwithflow.network

import com.mtbc.mvvmwithflow.loginSignup.request.SignupRequestModel
import com.mtbc.mvvmwithflow.loginSignup.response.UserLoginSignupResponse
import com.mtbc.mvvmwithflow.model.Posts
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Named

class ApiAServiceImpl @Inject constructor(@Named("mainRetrofit") private val apiService: ApiInterfaces) {
        suspend fun getPosts():Response<List<Posts>> = apiService.getPosts()
    suspend fun signup(request: SignupRequestModel): Response<UserLoginSignupResponse> =
        apiService.signup(request)
    suspend fun login(email:String,password:String): Response<UserLoginSignupResponse> =
        apiService.login(email,password)
}


