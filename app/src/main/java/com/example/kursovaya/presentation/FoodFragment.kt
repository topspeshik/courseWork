package com.example.kursovaya.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kursovaya.R
import com.example.kursovaya.databinding.FragmentAddDayBinding
import com.example.kursovaya.databinding.FragmentFoodBinding


class FoodFragment : Fragment() {

    private var _binding: FragmentFoodBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFoodBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ivBreakfastAdd.setOnClickListener{
            findNavController().navigate(FoodFragmentDirections.actionFoodFragmentToAddFoodFragment("Завтрак"))
        }
    }
}