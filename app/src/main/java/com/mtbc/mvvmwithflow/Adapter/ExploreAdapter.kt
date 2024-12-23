package com.mtbc.mvvmwithflow.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mtbc.mvvmwithflow.databinding.ExploreItemBinding


class ExploreAdapter(private var exploreList: List<String>) : RecyclerView.Adapter<ExploreAdapter.ExploreViewHolder>() {
    private lateinit var  binding: ExploreItemBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploreViewHolder {
        binding = ExploreItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ExploreViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return exploreList.size
    }

    override fun onBindViewHolder(holder: ExploreViewHolder, position: Int) {
           binding.tvExploreItem.text = exploreList[position]
    }
    class ExploreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}