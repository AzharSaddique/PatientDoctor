package com.mtbc.mvvmwithflow.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mtbc.mvvmwithflow.databinding.DrugItemBinding
import com.mtbc.mvvmwithflow.model.Drug


class DrugsAdapter(private var drugsList: List<Drug>, val context: Context) :
    RecyclerView.Adapter<DrugsAdapter.DrugsViewHolder>() {
    private lateinit var binding: DrugItemBinding

    init {
        setHasStableIds(true)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrugsViewHolder {
        binding = DrugItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DrugsViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return drugsList.size
    }

    override fun onBindViewHolder(holder: DrugsViewHolder, position: Int) {
        binding.tvName.text = drugsList.get(position).name
        binding.tvDosage.text = drugsList.get(position).dosage
        binding.tvFrequency.text = drugsList.get(position).frequency


    }



    class DrugsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }


    fun Int.dpToPx(context: Context): Int {
        return (this * context.resources.displayMetrics.density).toInt()
    }
}