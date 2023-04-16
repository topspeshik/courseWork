package com.example.kursovaya.presentation

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kursovaya.R
import com.example.kursovaya.databinding.FragmentAddFoodBinding
import com.example.kursovaya.databinding.FragmentMainBinding
import com.example.kursovaya.presentation.Food.FoodFragment
import com.example.kursovaya.presentation.Training.TrainingProcessFragment


class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val getKcal = FoodFragment.kcal
        binding.tvGetkcal.text = getKcal.toString()
        val lostKcal: String
        if (TrainingProcessFragment.timerTime != 0L )
            lostKcal = (TrainingProcessFragment.timerTime *8/ 1000).toString()
        else
            lostKcal = 0.toString()
        binding.tvLostkcal.text = lostKcal


        countProgressHorizontal()
        setupListeners()

        binding.etWeight.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                val currentWeight = parseCount(s.toString())

                if (currentWeight!=0){
                    val currentKcal = (66.5 + (13.75 * currentWeight) + (5.003 * 180) - (6.775 * 20)).toInt()
                    val totalKcal = currentKcal + lostKcal.toInt()-getKcal
                    binding.tvKcal.text = totalKcal.toString()
                    countProgressBar(currentKcal.toDouble(), totalKcal.toDouble())
                    countProgressHorizontal()
                }

            }
        })


    }

    fun countProgressHorizontal(){
        val currentWeight = parseCount(binding.etWeight.text.toString())
        val startWeight = parseCount(binding.etStartKg.text.toString())
        val endWeight = parseCount(binding.etEndKg.text.toString())
        val kg = endWeight - startWeight
        val currentKg = currentWeight - startWeight
        if (currentWeight!=0 && startWeight!=0 && endWeight!=0  )
            binding.progressHorizontal.progress = (currentKg*100)/kg

    }

    fun countProgressBar(currentKcal: Double, totalKcal: Double){
        binding.progressBar.progress = (100-(totalKcal/currentKcal)*100).toInt()
    }

    fun setupListeners(){
        binding.etEndKg.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                countProgressHorizontal()
            }
        })
        binding.etStartKg.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                countProgressHorizontal()
            }
        })
    }

    private fun parseCount(inputCount: String?): Int {
        return try {
            inputCount?.trim()?.toInt() ?: 0
        } catch (e: Exception) {
            0
        }
    }
}