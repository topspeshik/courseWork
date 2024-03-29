package com.example.kursovaya.presentation.Food

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.kursovaya.databinding.FragmentAddMealBinding
import com.example.kursovaya.domain.Food.db.FoodNetwork.FoodItem
import com.example.kursovaya.presentation.Training.TrainingApplication
import com.example.kursovaya.presentation.Training.ViewModelFactory
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
    ): View {
        component.inject(this)
        _binding = FragmentAddMealBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this,viewModelFactory)[AddMealViewModel::class.java]




        if (args.fragmentName == "FoodFragment"){
             viewModel.getFoodItem(args.mealsItem!!.food_name).observe(viewLifecycleOwner){ listFood->
                 with(binding){
                     tvCarbs.text = listFood[0].carb.toString()
                     tvFats.text = listFood[0].fats.toString()
                     tvCarbs.text = listFood[0].carb.toString()
                     tvKcal.text = listFood[0].kcal.toString()

                 }
                 binding.btnSaveFood.setOnClickListener{
                     viewModel.addBreakfastItem(args.nameMeal,listFood[0].name , binding.etWeight.text.toString(), args.mealsItem!!.id)
                     it.hideKeyboard()

                 }
            }


            binding.btnDeleteFood.visibility = View.VISIBLE
            binding.btnDeleteFood.setOnClickListener{
                viewModel.deleteMealsitem(args.mealsItem!!.id)
                findNavController().popBackStack()

            }
        } else{

            args.foodItem?.let { foodItem->
                with(binding){
                    tvCarbs.text = foodItem.carb.toString()
                    tvFats.text = foodItem.fats.toString()
                    tvCarbs.text = foodItem.carb.toString()
                    tvKcal.text = foodItem.kcal.toString()

                }
//                binding.btnSaveFood.setOnClickListener{
//                    viewModel.addBreakfastItem(args.nameMeal, foodItem.name, binding.etWeight.text.toString())
//                    it.hideKeyboard()
//
//                }
            }

        }



        viewModel.shouldCloseScreen.observe(viewLifecycleOwner){
            if (it)
                findNavController().popBackStack()
        }

        viewModel.errorInputCount.observe(viewLifecycleOwner){
            if(it){
                Toast.makeText(context,"Введите значения!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnBack.setOnClickListener{
            findNavController().popBackStack()
        }
    }



    private fun View.hideKeyboard() {
        val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(windowToken, 0)
    }
}

