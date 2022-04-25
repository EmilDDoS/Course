package com.example.usdcourse.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.usdcourse.databinding.CourseItemBinding
import com.example.usdcourse.domain.entity.CourseUSD

class CourseAdapter : RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {

    var courseList = listOf<CourseUSD>()
        set(value) {
            notifyDataSetChanged()
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        return CourseViewHolder(
            CourseItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        holder.bind(courseList[position])
    }

    override fun getItemCount(): Int = courseList.size

    class CourseViewHolder(
        private val binding: CourseItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(courseUSD: CourseUSD) {
            binding.date.text = courseUSD.date
            binding.course.text = courseUSD.value
        }
    }
}