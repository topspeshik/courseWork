package com.example.kursovaya.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.kursovaya.R
import com.example.kursovaya.databinding.FragmentAddFoodBinding
import com.example.kursovaya.databinding.FragmentAddMealBinding
import com.example.kursovaya.presentation.Training.StartTrainingAdapter.TrainingApplication
import com.example.kursovaya.presentation.Training.StartTrainingAdapter.ViewModelFactory
import javax.inject.Inject


class AddMealFragment : Fragment() {

    private val args by navArgs<AddMealFragmentArgs>()

    private var _binding: FragmentAddMealBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: AddMealViewModel

    private val component by lazy {
        (requireActivity().application as TrainingApplication).component
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        component.inject(this)
        _binding = FragmentAddMealBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this,viewModelFactory)[AddMealViewModel::class.java]
        with(binding){
            tvCarbs.text = args.foodItem.carb.toString()
            tvFats.text = args.foodItem.fats.toString()
            tvCarbs.text = args.foodItem.carb.toString()
            tvKcal.text = args.foodItem.kcal.toString()

        }

        binding.btnSaveFood.setOnClickListener{
            viewModel.addBreakfastItem(args.nameMeal, args.foodItem.name, binding.etWeight.text.toString().toInt())


        }
    }
}