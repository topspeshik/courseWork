package com.example.kursovaya.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.kursovaya.R
import com.example.kursovaya.presentation.Training.StartTrainingAdapter.TrainingFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {



    lateinit var bottomNav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment(TrainingFragment())
        bottomNav = findViewById(R.id.bottomNavigationView)
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    loadFragment(MainFragment())
                    true
                }
                R.id.food -> {
                    loadFragment(FoodFragment())
                    true
                }
                R.id.training -> {
                    loadFragment(TrainingFragment())
                    true
                }
                else -> {
                    loadFragment(MainFragment())
                    true
                }
            }
        }


    }

    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.commit()
    }
}