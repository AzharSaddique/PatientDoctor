package com.mtbc.mvvmwithflow.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mtbc.mvvmwithflow.R
import com.mtbc.mvvmwithflow.databinding.DoctorsItemBinding
import com.mtbc.mvvmwithflow.model.Doctor

class AllDoctorsAdapers(private var doctorsList: List<Doctor>, val context: Context) :
    RecyclerView.Adapter<AllDoctorsAdapers.DoctorsViewHolder>() {
    private lateinit var binding: DoctorsItemBinding

    init {
        setHasStableIds(true)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorsViewHolder {
        binding = DoctorsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DoctorsViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return 5
    }
    override fun getItemId(position: Int): Long {
        return doctorsList[position].email.hashCode().toLong() // Use a unique property like email
    }
    override fun onBindViewHolder(holder: DoctorsViewHolder, position: Int) {
        if (position <= 5) {
            // Access the root LinearLayout
            val layout = holder.itemView.findViewById<LinearLayout>(R.id.liDocMain)

            // Handle image loading
            val imageView = holder.itemView.findViewById<ImageView>(R.id.docImg)
            if (position == 4) {
                // For position 4, set a specific drawable
                imageView.setImageDrawable(
                    ResourcesCompat.getDrawable(
                        context.resources,
                        R.drawable.fiveplus,
                        context.theme
                    )
                )
            } else {
                // Load image from URL for other positions
                Glide.with(context)
                    .load("https://example.com/image.jpg")
                    .placeholder(R.drawable.placeholder) // Placeholder image
                    .error(R.drawable.baseline_error_24) // Error image
                    .into(imageView)
            }

            // Adjust marginStart dynamically
            val params = layout.layoutParams as ViewGroup.MarginLayoutParams
            when (position) {
                0 -> params.marginStart = 0 // No margin for the first item
                else -> params.marginStart = -10.dpToPx(holder.itemView.context) // Negative margin for others
            }
            layout.layoutParams = params
        }


    }

    class DoctorsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    fun Int.dpToPx(context: Context): Int {
        return (this * context.resources.displayMetrics.density).toInt()
    }
}