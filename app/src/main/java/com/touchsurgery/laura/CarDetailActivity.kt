package com.touchsurgery.laura

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.touchsurgery.laura.databinding.ActivityCarDetailBinding


class CarDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCarDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setValuesToViews()

        binding.iconBack.setOnClickListener{ finish() }
    }

    private fun setValuesToViews() {
        binding.textViewCarMake.text = intent.getStringExtra("carMake")
        binding.textViewCarYear.text = intent.getStringExtra("carYear")
        binding.textViewCarModel.text = intent.getStringExtra("carModel")
        binding.textViewCarDescription.text = intent.getStringExtra("carDescription")
    }
}