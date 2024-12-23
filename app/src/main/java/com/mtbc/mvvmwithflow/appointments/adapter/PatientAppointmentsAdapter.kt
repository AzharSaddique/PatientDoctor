package com.mtbc.mvvmwithflow.appointments.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mtbc.mvvmwithflow.appointments.model.AppointmentsModel
import com.mtbc.mvvmwithflow.databinding.AppointmentsItemBinding

class PatientAppointmentsAdapter(private val itemList: List<AppointmentsModel>) : RecyclerView.Adapter<PatientAppointmentsAdapter.ItemViewHolder>() {
    private lateinit var binding:AppointmentsItemBinding

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        binding = AppointmentsItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ItemViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemList[position]
        binding.tvPatientName.text = item.patientName
        binding.tvDisease.text = item.diseaseName
        binding.tvAppointmentTime.text = item.timeTo
    }

    override fun getItemCount(): Int = itemList.size
}
