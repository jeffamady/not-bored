package com.amadydev.notbored.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.amadydev.notbored.databinding.ActivityActivitiesBinding
import com.amadydev.notbored.model.Activities
import com.amadydev.notbored.viewmodel.ActivityAdapter
import com.amadydev.notbored.viewmodel.OnActivityClickListener

class ActivitiesActivity : AppCompatActivity(), OnActivityClickListener {
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

        activityAdapter = ActivityAdapter(Activities.activitiesList, this)
        with(binding.rvActivities){
            layoutManager = LinearLayoutManager(context)
            adapter = activityAdapter
        }
    }

    override fun onActivityItemClicked(position: Int) {
        goToDetails(position)
    }

    private fun goToDetails(position: Int) {
        val participant = intent.extras?.getString("INTENT_PART")!!
        val activity = Activities.activitiesList[position]
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("INTENT_PART", participant)
        intent.putExtra("INTENT_CAT", activity.category)
        intent.putExtra("INTENT_PRICE", activity.price)
        startActivity(intent)
    }
}