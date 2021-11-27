package com.amadydev.notbored.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
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
            etParticipants.addTextChangedListener{checkValue()}
            btnStart.setOnClickListener { goToActivities() }
        }
    }

    private fun goToActivities() {
        val intent = Intent(this, ActivitiesActivity::class.java)
        intent.putExtra("INTENT_PART", binding.etParticipants.text)
        startActivity(intent)
    }

    private fun checkValue() {
        with(binding) {
            etParticipants.text.let {
                if (it.isNullOrBlank()) {
                    modifyText("1")
                }
                val originalNum = it.toString()
                try {
                    if (originalNum.toInt() <= 0) {
                        btnStart.isEnabled = false
                        Toast.makeText(this@MainActivity,
                            "Only positive number",
                            Toast.LENGTH_SHORT).show()
                    } else{
                        btnStart.isEnabled = true
                        val num = originalNum.toInt().toString()
                        if (num != originalNum) {
                            modifyText(num)
                        }
                    }
                } catch (e: Exception) {
                    modifyText("")
                }
            }

        }

    }


    private fun modifyText(num: String) {
        binding.etParticipants.setText(num)
    }

    private fun goToTermsActivity() {
        startActivity(Intent(this, TermsAndConditionsActivity::class.java))
    }
}