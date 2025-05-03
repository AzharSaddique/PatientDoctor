package com.mtbc.mvvmwithflow.Adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mtbc.mvvmwithflow.databinding.ActiveFormerDoctorsItemBinding
import com.mtbc.mvvmwithflow.model.Doctor

class ActiveFormerDoctorsAdapers(private var doctorsList: List<Doctor>, val context: Context) :
    RecyclerView.Adapter<ActiveFormerDoctorsAdapers.ActiveDoctorsViewHolder>() {
    private lateinit var binding: ActiveFormerDoctorsItemBinding

    init {
        setHasStableIds(true)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActiveDoctorsViewHolder {
        binding = ActiveFormerDoctorsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ActiveDoctorsViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return doctorsList.size
    }
    override fun getItemId(position: Int): Long {
        return doctorsList[position].email.hashCode().toLong() // Use a unique property like email
    }
    override fun onBindViewHolder(holder: ActiveDoctorsViewHolder, position: Int) {
         binding.tvDoctorName.text = doctorsList.get(position).name
         binding.tvSpeacialization.text = doctorsList.get(position).specialization
         binding.tvReason.text = doctorsList.get(position).reason

    }

    class ActiveDoctorsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    fun Int.dpToPx(context: Context): Int {
        return (this * context.resources.displayMetrics.density).toInt()
    }
}