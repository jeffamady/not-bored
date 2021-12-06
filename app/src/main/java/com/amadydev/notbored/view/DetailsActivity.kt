package com.amadydev.notbored.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.amadydev.notbored.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }

    private fun initUI() {
        binding.btnBack.setOnClickListener { onBackPressed() }
        takeAndShowInfo()
    }

    private fun takeAndShowInfo() {
        with(binding) {
            val participants = intent.extras?.getString("INTENT_PART")!!
            val price = intent.extras?.getDouble("INTENT_PRICE")!!
            val category = intent.extras?.getString("INTENT_CAT")
            tvActivityTitle.text = category
            tvParticipant.text = participants
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