package com.mtbc.mvvmwithflow.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.mtbc.mvvmwithflow.Adapter.TabPagerAdapter
import com.mtbc.mvvmwithflow.databinding.ActivityPrescriptionBinding

class PrescriptionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPrescriptionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPrescriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)
      setUpTabs()
    }

    private fun setUpTabs() {
        // Set up ViewPager with Fragments
        binding.viewPager.adapter = TabPagerAdapter(this, "Prescription")

        // Connect TabLayout with ViewPager2
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Active"
                1 -> "History"
                else -> "Tab $position"
            }
        }.attach()
    }
}