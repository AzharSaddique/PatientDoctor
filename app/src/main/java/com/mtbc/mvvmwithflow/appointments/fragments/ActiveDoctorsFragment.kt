package com.mtbc.mvvmwithflow.appointments.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mtbc.mvvmwithflow.Adapter.ActiveFormerDoctorsAdapers
import com.mtbc.mvvmwithflow.databinding.FragmentActiveDoctorsBinding
import com.mtbc.mvvmwithflow.model.Doctor


class ActiveDoctorsFragment : Fragment() {
    private lateinit var binding: FragmentActiveDoctorsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding =  FragmentActiveDoctorsBinding.inflate(layoutInflater, container, false)
        setAllDoctors()
        return binding.root
    }

    private fun setAllDoctors() {
        val doctorList = listOf(
            Doctor(
                name = "Dr. John Smith",
                email = "john.smith@example.com",
                phone = "1234567890",
                age = "45",
                dob = "1978-05-20",
                imageUrl = "https://example.com/image1.jpg",
                address = "123 Main Street",
                specialization = "Cardiologist",
                reason = "Expert in treating heart-related conditions."
            ),
            Doctor(
                name = "Dr. Emily Davis",
                email = "emily.davis@example.com",
                phone = "9876543210",
                age = "38",
                dob = "1985-11-15",
                imageUrl = "https://example.com/image2.jpg",
                address = "456 Elm Avenue",
                specialization = "Pediatrician",
                reason = "Specializes in child health and development."
            ),
            Doctor(
                name = "Dr. Robert Brown",
                email = "robert.brown@example.com",
                phone = "1122334455",
                age = "50",
                dob = "1973-02-10",
                imageUrl = "https://example.com/image3.jpg",
                address = "789 Maple Lane",
                specialization = "Orthopedic Surgeon",
                reason = "Highly experienced in joint replacement surgeries."
            ),
            Doctor(
                name = "Dr. Sarah Wilson",
                email = "sarah.wilson@example.com",
                phone = "9988776655",
                age = "40",
                dob = "1983-07-25",
                imageUrl = "https://example.com/image4.jpg",
                address = "321 Oak Drive",
                specialization = "Dermatologist",
                reason = "Renowned for treating skin conditions and cosmetic issues."
            ),
            Doctor(
                name = "Dr. Michael Taylor",
                email = "michael.taylor@example.com",
                phone = "5566778899",
                age = "42",
                dob = "1981-03-30",
                imageUrl = "https://example.com/image5.jpg",
                address = "654 Pine Road",
                specialization = "Neurologist",
                reason = "Expert in diagnosing and managing neurological disorders."
            ),
            Doctor(
                name = "Dr. Jessica White",
                email = "jessica.white@example.com",
                phone = "6677889900",
                age = "36",
                dob = "1987-12-18",
                imageUrl = "https://example.com/image6.jpg",
                address = "987 Cedar Street",
                specialization = "Oncologist",
                reason = "Focuses on cancer diagnosis and treatment."
            ),
            Doctor(
                name = "Dr. William Harris",
                email = "william.harris@example.com",
                phone = "7788990011",
                age = "48",
                dob = "1975-09-22",
                imageUrl = "https://example.com/image7.jpg",
                address = "123 Birch Way",
                specialization = "General Surgeon",
                reason = "Experienced in performing a wide range of surgeries."
            ),
            Doctor(
                name = "Dr. Olivia Martinez",
                email = "olivia.martinez@example.com",
                phone = "8899001122",
                age = "34",
                dob = "1989-04-14",
                imageUrl = "https://example.com/image8.jpg",
                address = "456 Spruce Avenue",
                specialization = "Psychiatrist",
                reason = "Specializes in mental health and psychotherapy."
            ),
            Doctor(
                name = "Dr. James Anderson",
                email = "james.anderson@example.com",
                phone = "9900112233",
                age = "46",
                dob = "1977-06-08",
                imageUrl = "https://example.com/image9.jpg",
                address = "789 Aspen Boulevard",
                specialization = "Pulmonologist",
                reason = "Expert in treating respiratory system conditions."
            ),
            Doctor(
                name = "Dr. Sophia Thomas",
                email = "sophia.thomas@example.com",
                phone = "0011223344",
                age = "39",
                dob = "1984-08-12",
                imageUrl = "https://example.com/image10.jpg",
                address = "321 Willow Drive",
                specialization = "Endocrinologist",
                reason = "Focuses on hormonal imbalances and metabolic disorders."
            )
        )

        binding.rvActiveDoctors.adapter = ActiveFormerDoctorsAdapers(doctorList,requireContext())
    }


}