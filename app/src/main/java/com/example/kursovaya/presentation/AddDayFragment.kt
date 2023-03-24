package com.example.kursovaya.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.kursovaya.databinding.FragmentAddDayBinding
import com.example.kursovaya.presentation.AddDayAdapter.AddExerciseAdapter


class AddDayFragment : Fragment() {

    private lateinit var viewModel: AddDayViewModel
    private lateinit var addExerciseAdapter: AddExerciseAdapter

    private var _binding: FragmentAddDayBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddDayBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[AddDayViewModel::class.java]
        addExerciseAdapter = AddExerciseAdapter()
        binding.rvExercisesList.adapter = addExerciseAdapter
        binding.tvDay.text =  "День ${TrainingFragment.DAY_ID}"

        setupClickListener()

    }

    private fun setupClickListener(){
        binding.svExercises.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let { it ->
                    if (newText.isNotBlank()) {
                        viewModel.getTrainingList(it).observe(viewLifecycleOwner) {
                            addExerciseAdapter.submitList(it)
                        }
                    }
                }

                return true
            }
        })

        addExerciseAdapter.onExerciseItemClickListener = {
            findNavController().navigate(AddDayFragmentDirections.actionAddDayFragmentToAddExerciseFragment(it))
        }

    }

}