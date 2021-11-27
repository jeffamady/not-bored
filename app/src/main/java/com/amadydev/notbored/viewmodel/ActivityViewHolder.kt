package com.amadydev.notbored.viewmodel

import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.amadydev.notbored.databinding.ItemActivitiesBinding
import com.amadydev.notbored.model.ActivitiesModel

class ActivityViewHolder(private val binding: ItemActivitiesBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(activity: ActivitiesModel){
        binding.run{
            tvActivity.text = activity.category
            btnNext.setOnClickListener{
                Toast.makeText(it.context, "Activity ${activity.category} clicked", Toast.LENGTH_SHORT).show()
            }
        }
    }
}