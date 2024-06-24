package com.touchsurgery.laura

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.touchsurgery.laura.databinding.ActivityMainBinding

/** RecyclerViewEvent is used for the onClick() */

class MainCarListActivity : AppCompatActivity(), RecyclerViewEvent {

    lateinit var binding: ActivityMainBinding

    private var carsList = mutableListOf(
        Car("Ford", "Focus", "A small family car", 2019),
        Car("Ford", "Fiesta", "A small city car", 2018),
        Car("Ford", "Mondeo", "A large family car", 2017),
        Car("Ford", "Mustang", "A sports car", 2016),
        Car("Volkswagen", "Golf", "A small family car", 2015),
        Car("Volkswagen", "Polo", "A small city car", 2014),
        Car("Volkswagen", "Passat", "A large family car", 2013),
        Car("Volkswagen", "Beetle", "A small city car", 2012),
        Car("Volkswagen", "Tiguan", "A small SUV", 2011),
        Car("Volkswagen", "Touareg", "A large SUV", 2010),
        Car("Volkswagen", "Arteon", "A large family car", 2009),
        Car("BMW", "1 Series", "A small family car", 2008),
        Car("BMW", "2 Series", "A small family car", 2007),
        Car("BMW", "3 Series", "A small family car", 2006),
        Car("BMW", "4 Series", "A small family car", 2005),
        Car("Toyota", "Yaris", "A small city car", 2004),
        Car("Toyota", "Corolla", "A small family car", 2003),
        Car("Toyota", "Camry", "A large family car", 2002),
        Car("Toyota", "Supra", "A sports car", 2001)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        carsList.sortBy { it.year }

        var adapter = CarAdapter(carsList, this)

        /**fill recycler view with Car items , add click listener to implement the recycler view event */
        binding.reycleviewCarList.adapter = adapter /** set recycler adapter to our adapter */
        binding.reycleviewCarList.layoutManager = LinearLayoutManager(this)
        /** Standard layout manager to display items on the screen and a policy about when an item should be recycled */
    }

    override fun onItemClick(position: Int) {

        val intent = Intent(this@MainCarListActivity, CarDetailActivity::class.java)

        /** putExtras - uses key/pair values */
        intent.putExtra("carMake", carsList[position].make)
        intent.putExtra("carYear", carsList[position].year.toString())
        intent.putExtra("carModel", carsList[position].model)
        intent.putExtra("carDescription", carsList[position].description)
        startActivity(intent)
    }
}