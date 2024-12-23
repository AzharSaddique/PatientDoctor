package com.mtbc.mvvmwithflow.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.mtbc.mvvmwithflow.Adapter.PostsAdapter
import com.mtbc.mvvmwithflow.ViewModel.MainViewModel
import com.mtbc.mvvmwithflow.databinding.ActivityMainBinding
import com.mtbc.mvvmwithflow.util.ApiState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var postsAdapter: PostsAdapter
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecycler()

        mainViewModel.getPosts()
        lifecycleScope.launch {
            mainViewModel._postStateFlow.collect {
                when (it) {
                    is ApiState.Loading -> {
                        binding.rvPosts.isVisible = false
                        binding.progressBar.isVisible = true
                    }

                    is ApiState.Failure -> {
                        binding.rvPosts.isVisible = false
                        binding.progressBar.isVisible = true
                        Log.i("main", "onCreate:${it.msg}")
                    }

                    is ApiState.Success -> {
                        binding.rvPosts.isVisible = true
                        binding.progressBar.isVisible = false
                        postsAdapter.setData(it.data)
                    }

                    ApiState.Empty -> {

                    }
                }

            }
        }

    }

    private fun initRecycler() {
        postsAdapter = PostsAdapter(ArrayList())
        binding.rvPosts.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = postsAdapter
        }

    }
}