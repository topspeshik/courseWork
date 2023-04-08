package com.example.kursovaya.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.kursovaya.R
import com.example.kursovaya.databinding.FragmentAddDayBinding
import com.example.kursovaya.databinding.FragmentFoodBinding
import com.example.kursovaya.domain.Food.network.Food
import com.example.kursovaya.presentation.FoodAdapter.FoodAdapter
import com.example.kursovaya.presentation.FoodAdapter.FoodItemAdapter
import com.example.kursovaya.presentation.Training.StartTrainingAdapter.TrainingApplication
import com.example.kursovaya.presentation.Training.StartTrainingAdapter.ViewModelFactory
import javax.inject.Inject


class FoodFragment : Fragment() {

    private var _binding: FragmentFoodBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: FoodViewModel

    private var breakfastState = false

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
        _binding = FragmentFoodBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this,viewModelFactory)[FoodViewModel::class.java]
        setupBreakfast()

        binding.ivBreakfastAdd.setOnClickListener{
            findNavController().navigate(FoodFragmentDirections.actionFoodFragmentToAddFoodFragment("Завтрак"))
        }


    }

    private fun setupBreakfast(){
        viewModel.getBreakfastBJU().observe(viewLifecycleOwner){ listIt ->
            Log.d("checkshitbju", listIt.toString())
            var protein = 0
            var carb = 0
            var fats = 0
            listIt.forEach {
                protein += ((it.breakfastItem.weight / 100) * (it.foodItem.proteins))
                carb += ((it.breakfastItem.weight / 100) * (it.foodItem.carb))
                fats += ((it.breakfastItem.weight / 100) * (it.foodItem.fats))
                
            }
            binding.tvBfProteins.text = protein.toString()
            binding.tvBfCarb.text = carb.toString()
            binding.tvBfFats.text = fats.toString()


            var listFood: MutableList<FoodItemAdapter> = mutableListOf()

            listIt.forEach {
                listFood.add(
                    FoodItemAdapter(
                        it.breakfastItem.food_name,
                        it.foodItem.kcal * (it.breakfastItem.weight / 100)
                    )
                )
            }

            binding.lvBreakfast.adapter = FoodAdapter(listFood)

        }

        binding.cvBreakfast.setOnClickListener{
            if (!breakfastState) {
                binding.lvBreakfast.visibility = View.VISIBLE
                breakfastState = true
            }
            else{
                binding.lvBreakfast.visibility = View.GONE
                breakfastState = false
            }
        }


    }
}