package com.mtbc.mvvmwithflow.loginSignup.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.mtbc.mvvmwithflow.ViewModel.MainViewModel
import com.mtbc.mvvmwithflow.databinding.ActivityDoctorLoginBinding
import com.mtbc.mvvmwithflow.moveToActivity
import com.mtbc.mvvmwithflow.ui.MainDashboard
import com.mtbc.mvvmwithflow.util.ApiState
import com.mtbc.mvvmwithflow.util.Loader
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DoctorLoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDoctorLoginBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var loader: Loader

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoctorLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        loader = Loader(this)
        setUpObservers()

        binding.buttonLogin.setOnClickListener {
            if (validateInputs()) {
                val email = binding.textFieldEmail.editText?.text.toString().trim()
                val password = binding.textFieldPassword.editText?.text.toString()
                mainViewModel.login(email, password)
            }
        }
        binding.textViewSignup.setOnClickListener {
            moveToActivity(SignupActivity::class.java)
        }
    }

    private fun setUpObservers() {
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                mainViewModel.loginStateFlow.collect { state ->
                    when (state) {
                        is ApiState.Loading -> loader.show()
                        is ApiState.Success -> {
                            loader.dismiss()
                            Toast.makeText(this@DoctorLoginActivity, "Login Successful", Toast.LENGTH_SHORT).show()
                          moveToActivity(MainDashboard::class.java)
                        }
                        is ApiState.Error -> {
                            loader.dismiss()
                            Toast.makeText(this@DoctorLoginActivity, state.toString(), Toast.LENGTH_SHORT).show()
                        }
                        else -> {}
                    }
                }
            }
        }
    }

    private fun validateInputs(): Boolean {
        val email = binding.textFieldEmail.editText?.text.toString().trim()
        val password = binding.textFieldPassword.editText?.text.toString()
        if (email.isEmpty()) {
            binding.textFieldEmail.error = "Required"
            return false
        }
        if (password.isEmpty()) {
            binding.textFieldPassword.error = "Required"
            return false
        }
        binding.textFieldEmail.error = null
        binding.textFieldPassword.error = null
        return true
    }
}