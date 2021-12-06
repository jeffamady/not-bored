package com.amadydev.notbored.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import com.amadydev.notbored.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }

    private fun initUI() {
        with(binding) {
            tvConditions.setOnClickListener { goToTermsActivity() }
            etParticipants.doAfterTextChanged { afterTextChanged() }
            btnStart.setOnClickListener { goToActivities() }
        }
    }


    private fun goToActivities() {
        val intent = Intent(this, ActivitiesActivity::class.java)
        intent.putExtra("INTENT_PART", binding.etParticipants.text.toString())
        startActivity(intent)
    }

    private fun afterTextChanged() {
        val text = binding.etParticipants.text.toString()
        checkValue(text)
    }

    private fun checkValue(text: String) {
        with(binding) {
            try {
                if (text.toInt() > 0 && text.isNotEmpty()) {
                    btnStart.isEnabled = true
                } else showError()
            } catch (e: Exception) {
                showError()
            }
        }

    }

    private fun showError() {
        Toast.makeText(
            this@MainActivity,
            "Only positive number",
            Toast.LENGTH_SHORT
        ).show()
        binding.btnStart.isEnabled = false
    }

    private fun goToTermsActivity() {
        startActivity(Intent(this, TermsAndConditionsActivity::class.java))
    }

}

