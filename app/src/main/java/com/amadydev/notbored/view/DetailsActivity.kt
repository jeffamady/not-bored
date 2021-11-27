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
    }
}