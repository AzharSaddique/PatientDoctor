package com.mtbc.mvvmwithflow.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mtbc.mvvmwithflow.Adapter.ExploreAdapter
import com.mtbc.mvvmwithflow.R
import com.mtbc.mvvmwithflow.appointments.adapter.PatientAppointmentsAdapter
import com.mtbc.mvvmwithflow.appointments.model.AppointmentsModel
import com.mtbc.mvvmwithflow.databinding.ActivityDashboardBinding


class DashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setPatientsData()
        setExplore()


        // Find the NavHostFragment and get its NavController
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragmnet) as NavHostFragment
        navController = navHostFragment.navController

        NavigationUI.setupWithNavController(binding.bottomNavigationView,navController)
        // Get reference to the BottomNavigationView from the layout
        val navView: BottomNavigationView = binding.bottomNavigationView

        // Set item icon tint list to null (optional, to disable default icon tinting)
        navView.itemIconTintList = null

        // Set up the BottomNavigationView with the NavController for navigation
        navView.setupWithNavController(navController)
    }


    private fun setExplore() {
        val items = listOf("New Patient", "Investigation", "Claims")
        binding.rvExplore.adapter = ExploreAdapter(items)
    }

    private fun setPatientsData() {
        val appointments = listOf(
            AppointmentsModel(
                imagUrl = "https://via.placeholder.com/150",
                patientName = "John Doe",
                diseaseName = "Flu",
                timeFrom = "09:00 AM",
                timeTo = "10:00 AM"
            ), AppointmentsModel(
                imagUrl = "https://via.placeholder.com/150",
                patientName = "Jane Smith",
                diseaseName = "Fever",
                timeFrom = "10:15 AM",
                timeTo = "11:15 AM"
            ), AppointmentsModel(
                imagUrl = "https://via.placeholder.com/150",
                patientName = "Robert Johnson",
                diseaseName = "Cough",
                timeFrom = "11:30 AM",
                timeTo = "12:30 PM"
            ), AppointmentsModel(
                imagUrl = "https://via.placeholder.com/150",
                patientName = "Emily Davis",
                diseaseName = "Allergy",
                timeFrom = "01:00 PM",
                timeTo = "02:00 PM"
            ), AppointmentsModel(
                imagUrl = "https://via.placeholder.com/150",
                patientName = "Michael Brown",
                diseaseName = "Diabetes Check",
                timeFrom = "02:15 PM",
                timeTo = "03:15 PM"
            ), AppointmentsModel(
                imagUrl = "https://via.placeholder.com/150",
                patientName = "Sarah Wilson",
                diseaseName = "Hypertension",
                timeFrom = "03:30 PM",
                timeTo = "04:30 PM"
            ), AppointmentsModel(
                imagUrl = "https://via.placeholder.com/150",
                patientName = "William Martinez",
                diseaseName = "Back Pain",
                timeFrom = "05:00 PM",
                timeTo = "06:00 PM"
            ), AppointmentsModel(
                imagUrl = "https://via.placeholder.com/150",
                patientName = "Olivia Garcia",
                diseaseName = "Routine Checkup",
                timeFrom = "06:15 PM",
                timeTo = "07:15 PM"
            ), AppointmentsModel(
                imagUrl = "https://via.placeholder.com/150",
                patientName = "David Miller",
                diseaseName = "Skin Rash",
                timeFrom = "07:30 PM",
                timeTo = "08:30 PM"
            ), AppointmentsModel(
                imagUrl = "https://via.placeholder.com/150",
                patientName = "Sophia Gonzalez",
                diseaseName = "Migraine",
                timeFrom = "08:45 PM",
                timeTo = "09:45 PM"
            )
        )

        binding.rvAppointments.adapter = PatientAppointmentsAdapter(appointments)

    }

}