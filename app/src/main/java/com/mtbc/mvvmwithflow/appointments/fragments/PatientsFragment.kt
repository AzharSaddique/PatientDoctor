package com.mtbc.mvvmwithflow.appointments.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mtbc.mvvmwithflow.R
import com.mtbc.mvvmwithflow.databinding.FragmentPatientsBinding

class PatientsFragment : Fragment() {
    private lateinit var binding: FragmentPatientsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPatientsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}