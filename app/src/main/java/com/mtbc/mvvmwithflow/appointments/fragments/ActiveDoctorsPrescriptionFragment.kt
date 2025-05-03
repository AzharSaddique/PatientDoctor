package com.mtbc.mvvmwithflow.appointments.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mtbc.mvvmwithflow.Adapter.AllDoctorsPrescriptionAdapter
import com.mtbc.mvvmwithflow.R
import com.mtbc.mvvmwithflow.databinding.FragmentActiveDoctorsPrescriptionBinding
import com.mtbc.mvvmwithflow.model.Doctor
import com.mtbc.mvvmwithflow.model.Drug


class ActiveDoctorsPrescriptionFragment : Fragment() {
    private lateinit var binding:FragmentActiveDoctorsPrescriptionBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding =  FragmentActiveDoctorsPrescriptionBinding.inflate(layoutInflater, container, false)
        setActiveDoctorsPrescription()
        return binding.root
    }

    private fun setActiveDoctorsPrescription() {

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
                    reason = "Expert in treating heart-related conditions.",
                    drugDetails = listOf(
                        Drug(
                            name = "Aspirin",
                            dosage = "100 mg",
                            frequency = "Twice a day",
                            reason = "Blood thinning to reduce heart attack risk"
                        ),
                        Drug(
                            name = "Atorvastatin",
                            dosage = "20 mg",
                            frequency = "Once a day",
                            reason = "Cholesterol management"
                        )
                    )
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
                    reason = "Specializes in child health and development.",
                    drugDetails = listOf(
                        Drug(
                            name = "Amoxicillin",
                            dosage = "250 mg",
                            frequency = "Every 8 hours",
                            reason = "Common antibiotic for pediatric infections"
                        ),
                        Drug(
                            name = "Vitamin D supplement",
                            dosage = "400 IU",
                            frequency = "Once a day",
                            reason = "Supports child growth and bone health"
                        )
                    )
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
                    reason = "Highly experienced in joint replacement surgeries.",
                    drugDetails = listOf(
                        Drug(
                            name = "Ibuprofen",
                            dosage = "400 mg",
                            frequency = "Every 6 hours",
                            reason = "Post-surgical pain relief"
                        ),
                        Drug(
                            name = "Calcium supplement",
                            dosage = "500 mg",
                            frequency = "Once a day",
                            reason = "Bone health support"
                        )
                    )
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
                    reason = "Renowned for treating skin conditions and cosmetic issues.",
                    drugDetails = listOf(
                        Drug(
                            name = "Hydrocortisone cream",
                            dosage = "Apply topically",
                            frequency = "2-3 times a day",
                            reason = "Reduces inflammation/irritation"
                        ),
                        Drug(
                            name = "Tretinoin cream",
                            dosage = "Apply at night",
                            frequency = "Once daily",
                            reason = "Acne treatment / Anti-aging"
                        )
                    )
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
                    reason = "Expert in diagnosing and managing neurological disorders.",
                    drugDetails = listOf(
                        Drug(
                            name = "Gabapentin",
                            dosage = "300 mg",
                            frequency = "Twice a day",
                            reason = "Neuropathic pain management"
                        ),
                        Drug(
                            name = "Levetiracetam",
                            dosage = "500 mg",
                            frequency = "Twice a day",
                            reason = "Seizure control"
                        )
                    )
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
                    reason = "Focuses on cancer diagnosis and treatment.",
                    drugDetails = listOf(
                        Drug(
                            name = "Paclitaxel",
                            dosage = "100 mg/m²",
                            frequency = "Every 3 weeks",
                            reason = "Chemotherapy agent for cancer treatment"
                        ),
                        Drug(
                            name = "Ondansetron",
                            dosage = "8 mg",
                            frequency = "Every 12 hours as needed",
                            reason = "Prevents chemotherapy-induced nausea"
                        )
                    )
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
                    reason = "Experienced in performing a wide range of surgeries.",
                    drugDetails = listOf(
                        Drug(
                            name = "Cefazolin",
                            dosage = "1 g IV",
                            frequency = "Pre-surgery",
                            reason = "Antibiotic prophylaxis"
                        ),
                        Drug(
                            name = "Paracetamol",
                            dosage = "500 mg",
                            frequency = "Every 6 hours",
                            reason = "Post-operative pain relief"
                        )
                    )
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
                    reason = "Specializes in mental health and psychotherapy.",
                    drugDetails = listOf(
                        Drug(
                            name = "Sertraline",
                            dosage = "50 mg",
                            frequency = "Once a day",
                            reason = "Treatment for depression/anxiety"
                        ),
                        Drug(
                            name = "Alprazolam",
                            dosage = "0.5 mg",
                            frequency = "As needed for acute anxiety",
                            reason = "Short-term anxiety management"
                        )
                    )
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
                    reason = "Expert in treating respiratory system conditions.",
                    drugDetails = listOf(
                        Drug(
                            name = "Salbutamol inhaler",
                            dosage = "100 mcg/puff",
                            frequency = "As needed",
                            reason = "Relieve bronchospasm in asthma/COPD"
                        ),
                        Drug(
                            name = "Budesonide inhaler",
                            dosage = "200 mcg",
                            frequency = "Twice a day",
                            reason = "Corticosteroid inhaler for asthma/COPD"
                        )
                    )
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
                    reason = "Focuses on hormonal imbalances and metabolic disorders.",
                    drugDetails = listOf(
                        Drug(
                            name = "Metformin",
                            dosage = "500 mg",
                            frequency = "Twice a day",
                            reason = "Type 2 diabetes management"
                        ),
                        Drug(
                            name = "Levothyroxine",
                            dosage = "50 mcg",
                            frequency = "Once a day",
                            reason = "Treatment for hypothyroidism"
                        )
                    )
                )
            )
        binding.rvActiveDocPresc.adapter = AllDoctorsPrescriptionAdapter(doctorList, requireContext())

    }

}