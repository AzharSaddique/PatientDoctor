package com.mtbc.mvvmwithflow.Adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mtbc.mvvmwithflow.appointments.fragments.ActiveDoctorsFragment
import com.mtbc.mvvmwithflow.appointments.fragments.ActiveDoctorsPrescriptionFragment
import com.mtbc.mvvmwithflow.appointments.fragments.FormerDoctorsFragment

class TabPagerAdapter(activity: AppCompatActivity, val from: String) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 2 // Number of tabs
    override fun createFragment(position: Int): Fragment {
        return if (from.equals("Doctors", ignoreCase = true)) {
            when (position) {
                0 -> ActiveDoctorsFragment()
                1 -> FormerDoctorsFragment()
                else -> Fragment()
            }
        } else {
            when (position) {
                0 -> ActiveDoctorsPrescriptionFragment()
                1 -> FormerDoctorsFragment()
                else -> Fragment()
            }
        }
    }
}