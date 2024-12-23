package com.mtbc.mvvmwithflow.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mtbc.mvvmwithflow.Repository.MainRepository
import com.mtbc.mvvmwithflow.util.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject
constructor(private val mainRepository: MainRepository) : ViewModel() {
    private val postStateFlow: MutableStateFlow<ApiState> = MutableStateFlow(ApiState.Empty)
    val _postStateFlow: StateFlow<ApiState> = postStateFlow
    fun getPosts() = viewModelScope.launch {
        postStateFlow.value = ApiState.Loading
        mainRepository.getPosts()
            .catch { e ->
                postStateFlow.value = ApiState.Failure(e)
            }.collect { data ->
                postStateFlow.value = ApiState.Success(data)
            }
    }
}