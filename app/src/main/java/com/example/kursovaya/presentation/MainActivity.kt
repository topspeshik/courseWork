package com.example.kursovaya.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.kursovaya.R
import com.example.kursovaya.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {



    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide();
//        loadFragment(TrainingFragment())
//        bottomNav = findViewById(R.id.bottomNavigationView)
//        bottomNav.setOnItemSelectedListener {
//            when (it.itemId) {
//                R.id.home -> {
//                    loadFragment(MainFragment())
//                    true
//                }
//                R.id.food -> {
//                    loadFragment(FoodFragment())
//                    true
//                }
//                R.id.training -> {
//                    loadFragment(TrainingFragment())
//                    true
//                }
//                else -> {
//                    loadFragment(MainFragment())
//                    true
//                }
//            }
//        }

        val  navView: BottomNavigationView = binding.bottomNavigationView

        val navController = findNavController(R.id.container)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.foodFragment,
            R.id.trainingFragment,
            R.id.mainFragment))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)


    }

//    private  fun loadFragment(fragment: Fragment){
//        val transaction = supportFragmentManager.beginTransaction()
//        transaction.replace(R.id.container,fragment)
//        transaction.commit()
//    }
}