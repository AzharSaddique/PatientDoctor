package com.mtbc.mvvmwithflow.Adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.mtbc.mvvmwithflow.R
import com.mtbc.mvvmwithflow.model.DayItem

class MonthlyAdapter(private val context: Context,private val monthlyList: MutableList<DayItem>) :
    RecyclerView.Adapter<MonthlyAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvDate: TextView = itemView.findViewById(R.id.tvDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.monthly_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = monthlyList[position]
        holder.tvDate.text = item.date
        if(item.isSelected){

            holder.tvDate.background = ContextCompat.getDrawable(context, R.drawable.indicator_bg)
            holder.tvDate.setTextColor(ContextCompat.getColor(context,R.color.white))
        }else{
            holder.tvDate.setBackgroundColor(ContextCompat.getColor(context, R.color.white))
        }
    }

    override fun getItemCount(): Int = monthlyList.size
}
