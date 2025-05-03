package com.mtbc.mvvmwithflow.appointments.fragments

import android.content.Intent
import android.graphics.drawable.GradientDrawable.Orientation
import android.icu.util.Calendar
import android.os.Bundle
import android.util.LayoutDirection
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mtbc.mvvmwithflow.Adapter.MonthlyAdapter
import com.mtbc.mvvmwithflow.Adapter.SlotsAdapter
import com.mtbc.mvvmwithflow.R
import com.mtbc.mvvmwithflow.databinding.FragmentSchedulingBinding
import com.mtbc.mvvmwithflow.model.DayItem
import com.mtbc.mvvmwithflow.model.Slots
import com.mtbc.mvvmwithflow.ui.AllDoctors
import com.mtbc.mvvmwithflow.ui.PrescriptionActivity
import java.text.SimpleDateFormat
import java.util.Locale


class SchedulingFragment : Fragment() {
    private lateinit var binding: FragmentSchedulingBinding
    val monthlyList = mutableListOf<DayItem>()
    var count:Int = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSchedulingBinding.inflate(layoutInflater, container, false)


        getMonthWithAlignedDays(0)
        binding.imgPrevious.setOnClickListener {
         count--
         getMonthWithAlignedDays(count)
        }
        binding.imgNext.setOnClickListener {
            count++
            getMonthWithAlignedDays(count)
        }
        // Handle Mode Selection
        binding.radioGroupMode.setOnCheckedChangeListener { _, checkedId ->
            val selectedMode = when (checkedId) {
                R.id.radioAudio -> "Audio"
                R.id.radioVideo -> "Video"
                else -> "Audio"
            }
            Toast.makeText(requireContext(), "Selected Mode: $selectedMode", Toast.LENGTH_SHORT).show()
        }

        // Handle Schedule Button
        binding.btnSchedule.setOnClickListener {
            Toast.makeText(requireContext(), "Appointment Scheduled", Toast.LENGTH_SHORT).show()
            val intent = Intent(requireContext(),PrescriptionActivity::class.java)
            startActivity(intent)
         }
        return binding.root
    }
    private fun getMonthWithAlignedDays(i: Int) {
        val simpleDateFormat = SimpleDateFormat("d MMM yyyy", Locale.getDefault()) // Format dates as d MMM yyyy
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.MONTH, i)
        calendar.set(Calendar.DAY_OF_MONTH, 1)

        val currentDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        val currentMonth = Calendar.getInstance().get(Calendar.MONTH)
        val currentYear = Calendar.getInstance().get(Calendar.YEAR)

        val maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        val firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) // Get the starting day of the week

        val alignedDates = mutableListOf<DayItem>()

        // Adjust to align the first day with its header
        val startOffset = (firstDayOfWeek - Calendar.MONDAY + 7) % 7 // Adjust for Monday as the start

        // Add empty items to align with headers
        for (offset in 0 until startOffset) {
            alignedDates.add(DayItem("", "","", false)) // Empty placeholder
        }

        // Populate the dates
        for (day in 1..maxDay) {
            calendar.set(Calendar.DAY_OF_MONTH, day) // Set the day
            val formattedDate = simpleDateFormat.format(calendar.time) // Format the date
            val splitDate = formattedDate.split(" ") // Split into day and month
            val isSelected = (day == currentDay && i == currentMonth && calendar.get(Calendar.YEAR) == currentYear)

            alignedDates.add(DayItem(splitDate[0], splitDate[1],splitDate[2], isSelected))
        }

        monthlyList.clear()
        monthlyList.addAll(alignedDates)

        Log.i("alignedDates", alignedDates.toString())
        setMonthData()
    }


    private fun setMonthData() {
        // Set up RecyclerView with GridLayoutManager
        binding.rvCalendar.layoutManager = GridLayoutManager(requireContext(), 7) // 7 columns
        binding.rvCalendar.adapter = MonthlyAdapter(requireContext(),monthlyList)
        binding.tvMonthYear.text =  "${monthlyList[15].month} ${monthlyList[15].year}"
        setSlotsData()

    }
    private fun setSlotsData(){
       val slots = mutableListOf(Slots("06:00",false),Slots("07:00",false),Slots("08:00",false),Slots("09:00",false),
           Slots("10:00",false),Slots("11:00",false),Slots("12:00",false),Slots("01:00",false))
        binding.rvSlots.adapter = SlotsAdapter(slots)
    }

}
