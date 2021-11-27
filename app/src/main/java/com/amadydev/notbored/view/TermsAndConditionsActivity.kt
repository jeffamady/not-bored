package com.amadydev.notbored.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import com.amadydev.notbored.databinding.ActivityTermsAndConditionsBinding

class TermsAndConditionsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTermsAndConditionsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTermsAndConditionsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            ibBack.setOnClickListener { onBackPressed() }
            tvTermsAndConditions.movementMethod = ScrollingMovementMethod()
        }
    }
}