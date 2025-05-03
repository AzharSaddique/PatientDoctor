package com.mtbc.mvvmwithflow.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mtbc.mvvmwithflow.Repository.MainRepository
import com.mtbc.mvvmwithflow.loginSignup.request.SignupRequestModel
import com.mtbc.mvvmwithflow.loginSignup.response.UserLoginSignupResponse
import com.mtbc.mvvmwithflow.model.Posts
import com.mtbc.mvvmwithflow.util.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

    // Private mutable state flow
    val _postStateFlow = MutableStateFlow<ApiState<Response<List<Posts>>>>(ApiState.Idle)
     val _signUpStateFlow = MutableStateFlow<ApiState<Response<UserLoginSignupResponse>>>(ApiState.Idle)
     val _loginStateFlow = MutableStateFlow<ApiState<Response<UserLoginSignupResponse>>>(ApiState.Idle)

    // Publicly exposed as StateFlow
    val postStateFlow = _postStateFlow.asStateFlow()
    val signUpStateFlow = _signUpStateFlow.asStateFlow()
    val loginStateFlow = _loginStateFlow.asStateFlow()


    // Function to fetch appointments
    fun getPosts() {
        viewModelScope.launch {
            mainRepository.getPosts().collect { data ->
                _postStateFlow.value = data
            }
        }
    }
    fun signUp(request: SignupRequestModel) {
        viewModelScope.launch {
            mainRepository.signUp(request).collect { data ->
                _signUpStateFlow.value = data
            }
        }
    }
    fun login(email:String,password:String) {
        viewModelScope.launch {
            mainRepository.login(email,password).collect { data ->
                _loginStateFlow.value = data
            }
        }
    }
}
