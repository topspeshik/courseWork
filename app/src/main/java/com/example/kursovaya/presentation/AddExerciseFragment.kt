package com.example.kursovaya.presentation

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
import com.bumptech.glide.Glide
import com.example.kursovaya.databinding.FragmentAddExerciseBinding



class AddExerciseFragment : Fragment() {

    private val args by navArgs<AddExerciseFragmentArgs>()
    private lateinit var viewModel: AddExerciseViewModel

    private var _binding: FragmentAddExerciseBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddExerciseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[AddExerciseViewModel::class.java]

        with(binding){
            tvExercise.text = args.training.name
            Glide
                .with(root.context)
                .load(args.training.urlgif)
                .into(ivExercise)

            buttonAdd.setOnClickListener{
                viewModel.addExerciseItem(
                    TrainingFragment.DAY_ID,
                    binding.tvExercise.text.toString(),
                    binding.sets.text.toString(),
                    binding.reps.text.toString(),
                    binding.kg.text.toString(),
                    args.training.urlimg.toString(),
                    args.training.urlgif.toString()
                )
//                viewModel.exerciseDatabase.exerciseListDao().getExerciseListTest().observe(viewLifecycleOwner){
//                    Log.d("checkshit2", it.toString())
//                }
                view.hideKeyboard()
            }
        }
        observeViewModel()

    }

    private fun observeViewModel(){
        viewModel.errorInputCount.observe(viewLifecycleOwner){
            if(it){
                Toast.makeText(context,"Введите значения!", Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.shouldCloseScreen.observe(viewLifecycleOwner){
            if (it)
                findNavController().popBackStack()
        }

    }

    fun View.hideKeyboard() {
        val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(windowToken, 0)
    }
}