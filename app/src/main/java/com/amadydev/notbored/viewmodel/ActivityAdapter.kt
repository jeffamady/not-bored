package com.amadydev.notbored.viewmodel

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.amadydev.notbored.databinding.ItemActivitiesBinding
import com.amadydev.notbored.model.ActivitiesModel
import com.amadydev.notbored.view.DetailsActivity

class ActivityAdapter(
    private val activities: List<ActivitiesModel>,
    private val onActivityClickListener: OnActivityClickListener
) :
    RecyclerView.Adapter<ActivityViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemActivitiesBinding.inflate(layoutInflater, parent, false)
        return ActivityViewHolder(binding, onActivityClickListener)
    }

    override fun onBindViewHolder(holder: ActivityViewHolder, position: Int) {
        holder.bind(activities[position])
    }

    override fun getItemCount(): Int = activities.size

}

class ActivityViewHolder(
    private val binding: ItemActivitiesBinding,
    onActivityClickListener: OnActivityClickListener
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(activity: ActivitiesModel) {
        binding.run {
            tvActivity.text = activity.category

        }
    }

    init {
        binding.btnNext.setOnClickListener{
            onActivityClickListener.onActivityItemClicked(adapterPosition)
        }
    }
}

interface OnActivityClickListener {
    fun onActivityItemClicked(position: Int)
}