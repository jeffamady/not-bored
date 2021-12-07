package com.amadydev.notbored.ui.activity

import android.content.Intent
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.amadydev.notbored.R
import com.amadydev.notbored.databinding.ActivityActivitiesBinding
import com.amadydev.notbored.model.Activities
import com.amadydev.notbored.model.ActivitiesModel
import com.amadydev.notbored.ui.details.DetailsActivity
import com.amadydev.notbored.viewmodel.ActivityAdapter
import com.amadydev.notbored.viewmodel.OnActivityClickListener

class ActivitiesActivity : AppCompatActivity(), OnActivityClickListener {
    private val activities: List<ActivitiesModel> = Activities.activitiesList

    private lateinit var activityAdapter: ActivityAdapter
    private lateinit var binding: ActivityActivitiesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActivitiesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
        this.window.statusBarColor = ResourcesCompat.getColor(resources, R.color.color_b, null)
    }

    private fun initUI() {
        binding.btnRandom.setOnClickListener {
            val positionRandom = getRandomNum()
            goToDetails(positionRandom, true)
        }
        initRecycler()
    }

    private fun initRecycler() {

        activityAdapter = ActivityAdapter(Activities.activitiesList, this)
        with(binding.rvActivities) {
            layoutManager = LinearLayoutManager(context)
            adapter = activityAdapter
        }
    }

    override fun onActivityItemClicked(position: Int) {
        goToDetails(position, false)
    }

    private fun goToDetails(position: Int, random: Boolean) {
        val participant = intent.extras?.getString("INTENT_PART")!!
        val activity = activities[position]
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("INTENT_PART", participant)
        intent.putExtra("INTENT_CAT", activity.category)
        intent.putExtra("INTENT_PRICE", activity.price)
        intent.putExtra("INTENT_INFO", activity.info)
        intent.putExtra("INTENT_RANDOM", random)
        startActivity(intent)
    }

    private fun getRandomNum(): Int = activities.indices.random()
}