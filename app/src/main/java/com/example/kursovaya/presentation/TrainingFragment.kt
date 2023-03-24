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
import com.example.kursovaya.data.network.ApiFactory
import com.example.kursovaya.databinding.FragmentTrainingBinding
import com.example.kursovaya.presentation.TrainingAdapter.TrainingAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TrainingFragment : Fragment() {

    private lateinit var viewModel: TrainingViewModel
    private lateinit var trainingAdapter: TrainingAdapter
    private var currentDay: Int = 0

    private var _binding: FragmentTrainingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentTrainingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[TrainingViewModel::class.java]
        trainingAdapter = TrainingAdapter()
        binding.rvDaysList.adapter = trainingAdapter

        viewModel.daysList.observe(viewLifecycleOwner){
            Log.d("checkshit", it.toString())
            trainingAdapter.submitList(it)
        }

        trainingAdapter.onExerciseItemClickListener = {
            findNavController().navigate(TrainingFragmentDirections.actionTrainingFragmentToStartTrainFragment(it))
        }

        trainingAdapter.onActiveCheckBoxClickListener = {
            viewModel.updateActiveToInactive(it)
        }

        trainingAdapter.onInactiveCheckBoxClickListener = {
            viewModel.updateInactiveToActive(it)
        }

        viewModel.getCurrentDay.observe(viewLifecycleOwner){
            currentDay = it ?: 0
        }

        val btn = view.findViewById<FloatingActionButton>(R.id.buttonAddDay)
        val apiService = ApiFactory.apiService
        btn.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch {
                Log.d("checkApi", apiService.getTrainingList().toString())
            }
            DAY_ID=currentDay+1
            findNavController().navigate(R.id.action_trainingFragment_to_addDayFragment)
        }

    }

    companion object {
        var DAY_ID = 0
    }

}