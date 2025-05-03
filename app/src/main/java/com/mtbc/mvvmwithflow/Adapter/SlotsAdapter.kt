package com.mtbc.mvvmwithflow.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mtbc.mvvmwithflow.databinding.SlotsItemBinding
import com.mtbc.mvvmwithflow.model.Slots

class SlotsAdapter(private var slotsList: List<Slots>) : RecyclerView.Adapter<SlotsAdapter.SlotsViewHolder>() {
    private lateinit var  binding: SlotsItemBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SlotsViewHolder {
        binding = SlotsItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SlotsViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return slotsList.size
    }

    override fun onBindViewHolder(holder: SlotsViewHolder, position: Int) {
        binding.tvSlot.text = slotsList[position].time
    }
    class SlotsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}