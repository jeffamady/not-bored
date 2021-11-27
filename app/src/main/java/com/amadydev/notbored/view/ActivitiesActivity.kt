package com.amadydev.notbored.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.amadydev.notbored.databinding.ActivityActivitiesBinding
import com.amadydev.notbored.model.Activities
import com.amadydev.notbored.viewmodel.ActivityAdapter

class ActivitiesActivity : AppCompatActivity() {
    private lateinit var activityAdapter: ActivityAdapter
    private lateinit var binding: ActivityActivitiesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActivitiesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }

    private fun initUI() {
        initRecycler()
    }

    private fun initRecycler() {
        activityAdapter = ActivityAdapter(Activities.activitiesList)
        with(binding.rvActivities){
            layoutManager = LinearLayoutManager(context)
            adapter = activityAdapter
        }
    }
}