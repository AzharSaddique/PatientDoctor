package com.mtbc.mvvmwithflow.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mtbc.mvvmwithflow.databinding.ActivityDrugBinding

class DrugActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDrugBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDrugBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}