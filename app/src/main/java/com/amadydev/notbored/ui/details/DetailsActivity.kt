package com.amadydev.notbored.ui.details

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import com.amadydev.notbored.databinding.ActivityDetailsBinding
import com.amadydev.notbored.model.Activities
import com.amadydev.notbored.model.ActivitiesModel

class DetailsActivity : AppCompatActivity() {
    private val activities: List<ActivitiesModel> = Activities.activitiesList

    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }

    private fun initUI() {
        with(binding) {
            btnBack.setOnClickListener { onBackPressed() }
            btnTry.setOnClickListener { tryAnother() }
        }
        takeAndShowInfo()
    }

    private fun tryAnother() {
        val randomNum = activities.indices.random()
        val activity = activities[randomNum]
        val category = activity.category
        val price = activity.price
        val info = activity.info
        showText(category, info, price)
    }

    @SuppressLint("SetTextI18n")
    private fun takeAndShowInfo() {
        val price = intent.extras?.getDouble("INTENT_PRICE")!!
        val category = intent.extras?.getString("INTENT_CAT")
        val info = intent.extras?.getString("INTENT_INFO")
        showText(category, info, price)
    }

    @SuppressLint("SetTextI18n")
    private fun showText(category: String?, info: String?, price: Double) {
        val participants = intent.extras?.getString("INTENT_PART")!!
        val random = intent.extras?.getBoolean("INTENT_RANDOM")!!

        with(binding) {
            if (random) {
                tvActivityTitle.text = "Random"
                with(tvRandom) {
                    isVisible = true
                    text = category
                }
                tvParticipant.text = participants
                tvInfo.text = info
                tvPrice.text =
                    when (price) {
                        0.0 -> "Free"
                        in 0.0..0.3 -> "Low"
                        in 0.3..0.6 -> "Medium"
                        in 0.6..1.0 -> "High"
                        else -> ""
                    }
            } else {
                tvActivityTitle.text = category
                tvParticipant.text = participants
                tvInfo.text = info
                tvPrice.text =
                    when (price) {
                        0.0 -> "Free"
                        in 0.0..0.3 -> "Low"
                        in 0.3..0.6 -> "Medium"
                        in 0.6..1.0 -> "High"
                        else -> ""
                    }
            }
        }
    }
}