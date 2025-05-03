package com.mtbc.mvvmwithflow.Repository

import com.mtbc.mvvmwithflow.loginSignup.request.SignupRequestModel
import com.mtbc.mvvmwithflow.loginSignup.response.UserLoginSignupResponse
import com.mtbc.mvvmwithflow.model.Posts
import com.mtbc.mvvmwithflow.network.ApiAServiceImpl
import com.mtbc.mvvmwithflow.parseError
import com.mtbc.mvvmwithflow.util.ApiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import javax.inject.Inject

class MainRepository
@Inject
constructor(private val apiServiceImpl: ApiAServiceImpl) {

    suspend fun getPosts(): Flow<ApiState<Response<List<Posts>>>> =
        flow {
            emit(ApiState.Loading)
            val response = apiServiceImpl.getPosts()
            if (response.isSuccessful()) {
                emit(ApiState.Success(response))
            } else {
                val errorMessage = parseError(response)
                emit(ApiState.Error(Exception(errorMessage)))
            }
        }.catch { e ->
            emit(ApiState.Error(e))
        }.flowOn(Dispatchers.IO)


    suspend fun signUp(model: SignupRequestModel): Flow<ApiState<Response<UserLoginSignupResponse>>> =
        flow {
            emit(ApiState.Loading)
            val response = apiServiceImpl.signup(model)
            if (response.isSuccessful()) {
                emit(ApiState.Success(response))
            } else {
                val errorMessage = parseError(response)
                emit(ApiState.Error(Exception(errorMessage)))
            }
        }.catch { e ->
            emit(ApiState.Error(e))
        }.flowOn(Dispatchers.IO)

    suspend fun login(email:String,password:String): Flow<ApiState<Response<UserLoginSignupResponse>>> =
        flow {
            emit(ApiState.Loading)
            val response = apiServiceImpl.login(email,password)
            if (response.isSuccessful()) {
                emit(ApiState.Success(response))
            } else {
                val errorMessage = parseError(response)
                emit(ApiState.Error(Exception(errorMessage)))
            }
        }.catch { e ->
            emit(ApiState.Error(e))
        }.flowOn(Dispatchers.IO)

}
