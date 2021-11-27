package com.amadydev.notbored.viewmodel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amadydev.notbored.databinding.ItemActivitiesBinding
import com.amadydev.notbored.model.ActivitiesModel

class ActivityAdapter(val activities: List<ActivitiesModel>):
    RecyclerView.Adapter<ActivityViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemActivitiesBinding.inflate(layoutInflater, parent, false)
        return ActivityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ActivityViewHolder, position: Int) {
        holder.bind(activities[position])
    }

    override fun getItemCount(): Int = activities.size

}