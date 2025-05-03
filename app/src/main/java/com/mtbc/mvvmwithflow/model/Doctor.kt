package com.mtbc.mvvmwithflow.model

data class Doctor(
    val name: String,
    val email: String,
    val phone:String,
    val age:String,
    val dob:String,
    val imageUrl:String,
    val address:String,
    val specialization:String,
    val reason:String,
    val drugDetails: List<Drug> = emptyList()

)
data class Drug(
    val name: String,
    val dosage: String,
    val frequency: String,
    val reason: String
)