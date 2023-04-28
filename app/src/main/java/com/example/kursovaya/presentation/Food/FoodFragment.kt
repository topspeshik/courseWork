package com.example.kursovaya.presentation.Food

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.kursovaya.databinding.FragmentFoodBinding
import com.example.kursovaya.presentation.Food.FoodAdapter.FoodAdapter
import com.example.kursovaya.presentation.Food.FoodAdapter.FoodItemAdapter
import com.example.kursovaya.presentation.Training.TrainingApplication
import com.example.kursovaya.presentation.Training.ViewModelFactory
import javax.inject.Inject


class FoodFragment : Fragment() {

    private var _binding: FragmentFoodBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: FoodViewModel

    private var breakfastState = false
    private var lunchState = false
    private var dinnerState = false
    private var snackState = false

    private val component by lazy {
        (requireActivity().application as TrainingApplication).component
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        component.inject(this)
        _binding = FragmentFoodBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[FoodViewModel::class.java]
        setupBreakfast()
        setupLunch()
        setupDinner()
        setupSnack()
        setupUpper()

        binding.ivBreakfastAdd.setOnClickListener {
            findNavController().navigate(
                FoodFragmentDirections.actionFoodFragmentToAddFoodFragment(
                    "Завтрак"
                )
            )
        }

        binding.ivLunchAdd.setOnClickListener {
            findNavController().navigate(
                FoodFragmentDirections.actionFoodFragmentToAddFoodFragment(
                    "Обед"
                )
            )
        }

        binding.ivDinnerAdd.setOnClickListener {
            findNavController().navigate(
                FoodFragmentDirections.actionFoodFragmentToAddFoodFragment(
                    "Ужин"
                )
            )
        }

        binding.ivSnackAdd.setOnClickListener {
            findNavController().navigate(
                FoodFragmentDirections.actionFoodFragmentToAddFoodFragment(
                    "Перекус"
                )
            )
        }


    }


    private fun setupBreakfast() {
        viewModel.getMealBJU("Завтрак").observe(viewLifecycleOwner) { listIt ->
            Log.d("checkshitbju", listIt.toString())
            var protein = 0
            var carb = 0
            var fats = 0
            listIt.forEach {
                protein += ((it.mealsItem.weight / 100) * (it.foodItem.proteins))
                carb += ((it.mealsItem.weight / 100) * (it.foodItem.carb))
                fats += ((it.mealsItem.weight / 100) * (it.foodItem.fats))

            }
            binding.tvBfProteins.text = protein.toString()
            binding.tvBfCarb.text = carb.toString()
            binding.tvBfFats.text = fats.toString()


            val listFood: MutableList<FoodItemAdapter> = mutableListOf()

            listIt.forEach {
                listFood.add(
                    FoodItemAdapter(
                        it.mealsItem.food_name,
                        it.foodItem.kcal * it.mealsItem.weight / 100,
                        it.mealsItem.id
                    )
                )
            }
            val foodAdapter =  FoodAdapter(listFood)
            binding.lvBreakfast.adapter = foodAdapter
            setupUpper()
            foodAdapter.onFoodItemClickListener = {
                viewModel.deleteMealsItem(it.Id)

            }
        }

        binding.cvBreakfast.setOnClickListener {
            if (!breakfastState) {
                binding.lvBreakfast.visibility = View.VISIBLE
                breakfastState = true
            } else {
                binding.lvBreakfast.visibility = View.GONE
                breakfastState = false
            }
        }



    }

    private fun setupLunch() {
        viewModel.getMealBJU("Обед").observe(viewLifecycleOwner) { listIt ->
            Log.d("checkshitbju", listIt.toString())
            var protein = 0
            var carb = 0
            var fats = 0
            listIt.forEach {
                protein += ((it.mealsItem.weight / 100) * (it.foodItem.proteins))
                carb += ((it.mealsItem.weight / 100) * (it.foodItem.carb))
                fats += ((it.mealsItem.weight / 100) * (it.foodItem.fats))

            }
            binding.tvLProteins.text = protein.toString()
            binding.tvLCarb.text = carb.toString()
            binding.tvLFats.text = fats.toString()


            val listFood: MutableList<FoodItemAdapter> = mutableListOf()

            listIt.forEach {
                listFood.add(
                    FoodItemAdapter(
                        it.mealsItem.food_name,
                        it.foodItem.kcal * it.mealsItem.weight / 100,
                        it.mealsItem.id
                    )
                )
            }
            val foodAdapter =  FoodAdapter(listFood)
            binding.lvLunch.adapter = foodAdapter
            setupUpper()
            foodAdapter.onFoodItemClickListener = {
                viewModel.deleteMealsItem(it.Id)

            }
        }

        binding.cvLunch.setOnClickListener {
            if (!lunchState) {
                binding.lvLunch.visibility = View.VISIBLE
                lunchState = true
            } else {
                binding.lvLunch.visibility = View.GONE
                lunchState = false
            }
        }

    }

    private fun setupDinner() {
        viewModel.getMealBJU("Ужин").observe(viewLifecycleOwner) { listIt ->
            Log.d("checkshitbju", listIt.toString())
            var protein = 0
            var carb = 0
            var fats = 0
            listIt.forEach {
                protein += ((it.mealsItem.weight / 100) * (it.foodItem.proteins))
                carb += ((it.mealsItem.weight / 100) * (it.foodItem.carb))
                fats += ((it.mealsItem.weight / 100) * (it.foodItem.fats))

            }
            binding.tvDProteins.text = protein.toString()
            binding.tvDCarb.text = carb.toString()
            binding.tvDFats.text = fats.toString()


            val listFood: MutableList<FoodItemAdapter> = mutableListOf()

            listIt.forEach {
                listFood.add(
                    FoodItemAdapter(
                        it.mealsItem.food_name,
                        it.foodItem.kcal * it.mealsItem.weight / 100,
                        it.mealsItem.id
                    )
                )
            }
            val foodAdapter = FoodAdapter(listFood)
            binding.lvDinner.adapter = foodAdapter
            setupUpper()

            foodAdapter.onFoodItemClickListener = {
                viewModel.deleteMealsItem(it.Id)

            }
        }

        binding.cvDinner.setOnClickListener {
            if (!dinnerState) {
                binding.lvDinner.visibility = View.VISIBLE
                dinnerState = true
            } else {
                binding.lvDinner.visibility = View.GONE
                dinnerState = false
            }
        }

    }

    private fun setupSnack() {
        viewModel.getMealBJU("Перекус").observe(viewLifecycleOwner) { listIt ->
            Log.d("checkshitbju", listIt.toString())
            var protein = 0
            var carb = 0
            var fats = 0
            listIt.forEach {
                protein += ((it.mealsItem.weight / 100) * (it.foodItem.proteins))
                carb += ((it.mealsItem.weight / 100) * (it.foodItem.carb))
                fats += ((it.mealsItem.weight / 100) * (it.foodItem.fats))

            }
            binding.tvNProteins.text = protein.toString()
            binding.tvNCarb.text = carb.toString()
            binding.tvNFats.text = fats.toString()


            val listFood: MutableList<FoodItemAdapter> = mutableListOf()

            listIt.forEach {
                listFood.add(
                    FoodItemAdapter(
                        it.mealsItem.food_name,
                        it.foodItem.kcal * it.mealsItem.weight / 100,
                        it.mealsItem.id
                    )
                )
            }
            val foodAdapter = FoodAdapter(listFood)
            binding.lvSnack.adapter = foodAdapter
            setupUpper()
            foodAdapter.onFoodItemClickListener = {
                viewModel.deleteMealsItem(it.Id)

            }

        }

        binding.cvSnack.setOnClickListener {
            if (!snackState) {
                binding.lvSnack.visibility = View.VISIBLE
                snackState = true
            } else {
                binding.lvSnack.visibility = View.GONE
                snackState = false
            }
        }

    }

    private fun setupUpper() {
        var proteins: Int
        var fats: Int
        var carb: Int


        with(binding) {
            proteins = tvBfProteins.text.toString().toInt() +
                    tvLProteins.text.toString().toInt() +
                    tvDProteins.text.toString().toInt() +
                    tvNProteins.text.toString().toInt()
            fats = tvBfFats.text.toString().toInt() +
                    tvLFats.text.toString().toInt() +
                    tvDFats.text.toString().toInt() +
                    tvNFats.text.toString().toInt()
            carb = tvBfCarb.text.toString().toInt() +
                    tvLCarb.text.toString().toInt() +
                    tvDCarb.text.toString().toInt() +
                    tvNCarb.text.toString().toInt()
            kcal = proteins*4 + fats*9 + carb*4
            Log.d("checkshitupper", tvBfProteins.text.toString())
            tvProteins.text = proteins.toString()
            tvFat.text = fats.toString()
            tvCarb.text = carb.toString()
            tvKkcal.text = kcal.toString()
        }
    }

    companion object {
        var kcal = 0
    }
}