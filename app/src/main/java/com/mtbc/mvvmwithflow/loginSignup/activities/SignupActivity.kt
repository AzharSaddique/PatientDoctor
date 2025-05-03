package com.mtbc.mvvmwithflow.loginSignup.activities


import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.mtbc.mvvmwithflow.ViewModel.MainViewModel
import com.mtbc.mvvmwithflow.databinding.ActivitySignupBinding
import com.mtbc.mvvmwithflow.loginSignup.request.SignupRequestModel
import com.mtbc.mvvmwithflow.moveToActivity
import com.mtbc.mvvmwithflow.util.ApiState
import com.mtbc.mvvmwithflow.util.Loader
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.util.Calendar
@AndroidEntryPoint
class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var loader: Loader

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loader = Loader(this)
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        setUpObservers()
        // Spinner data
        val roles = listOf("Patient", "Doctor")
        val genders = listOf("Male", "Female")
        binding.spRole.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, roles)
        binding.spGender.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, genders)

        // Date picker for DOB
        binding.dobLayout.editText?.setOnClickListener {
            val c = Calendar.getInstance()
            DatePickerDialog(this, { _, y, m, d ->
                binding.dobLayout.editText?.setText(String.format("%04d-%02d-%02d", y, m + 1, d))
            }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show()
        }

        // Signup button click
        binding.btnSignup.setOnClickListener {
            if (validateInputs()) {
                val request = SignupRequestModel(
                    Address = binding.addressLayout.editText?.text.toString().trim(),
                    DateOfBirth = binding.dobLayout.editText?.text.toString().trim(),
                    Email = binding.emailLayout.editText?.text.toString().trim(),
                    F_Name = binding.firstName.editText?.text.toString().trim(),
                    Gender = binding.spGender.selectedItem.toString(),
                    L_Name = binding.lastName.editText?.text.toString().trim(),
                    Mobile_No = binding.phoneLayout.editText?.text.toString().trim(),
                    Password = binding.passwordLayout.editText?.text.toString(),
                    Role = binding.spRole.selectedItem.toString()
                )
                mainViewModel.signUp(request)

            }
        }
        binding.tvLogin.setOnClickListener {
            moveToActivity(DoctorLoginActivity::class.java)
        }
    }

    private fun setUpObservers() {
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                mainViewModel.signUpStateFlow.collect { state ->
                    when (state) {
                        is ApiState.Loading -> {
                            loader.show()
                        }

                        is ApiState.Success -> {
                            loader.dismiss()
                            Toast.makeText(
                                this@SignupActivity, "Signup Successful", Toast.LENGTH_SHORT
                            ).show()
                            moveToActivity(DoctorLoginActivity::class.java)

                        }

                        is ApiState.Error -> {
                            loader.dismiss()
                            Toast.makeText(
                                this@SignupActivity, state.toString(), Toast.LENGTH_SHORT
                            ).show()
                        }

                        else -> {}
                    }
                }
            }
        }

    }



    private fun validateInputs(): Boolean {
        val firstName = binding.firstName.editText?.text.toString().trim()
        val lastName = binding.lastName.editText?.text.toString().trim()
        val email = binding.emailLayout.editText?.text.toString().trim()
        val phone = binding.phoneLayout.editText?.text.toString().trim()
        val address = binding.addressLayout.editText?.text.toString().trim()
        val dob = binding.dobLayout.editText?.text.toString().trim()
        val password = binding.passwordLayout.editText?.text.toString()
        val confirmPassword = binding.confirmPassword.editText?.text.toString()

        if (firstName.isEmpty()) {
            binding.firstName.error = "Required"; return false
        }
        if (lastName.isEmpty()) {
            binding.lastName.error = "Required"; return false
        }
        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.emailLayout.error = "Valid email required"; return false
        }
        if (phone.isEmpty()) {
            binding.phoneLayout.error = "Required"; return false
        }
        if (address.isEmpty()) {
            binding.addressLayout.error = "Required"; return false
        }
        if (dob.isEmpty()) {
            binding.dobLayout.error = "Required"; return false
        }
        if (password.length < 6) {
            binding.passwordLayout.error = "Min 6 chars"; return false
        }
        if (password != confirmPassword) {
            binding.confirmPassword.error = "Passwords do not match"; return false
        }
        binding.firstName.error = null
        binding.lastName.error = null
        binding.emailLayout.error = null
        binding.phoneLayout.error = null
        binding.addressLayout.error = null
        binding.dobLayout.error = null
        binding.passwordLayout.error = null
        binding.confirmPassword.error = null
        return true
    }

}