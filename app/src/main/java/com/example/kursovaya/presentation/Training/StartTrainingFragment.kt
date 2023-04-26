package com.example.kursovaya.presentation.Training

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.kursovaya.databinding.FragmentStartTrainingBinding
import com.example.kursovaya.presentation.Training.StartTrainingAdapter.StartTrainingAdapter
import javax.inject.Inject


class StartTrainingFragment : Fragment() {

    private val args by navArgs<StartTrainingFragmentArgs>()
    private lateinit var startTrainingAdapter: StartTrainingAdapter
    private lateinit var viewModel: StartTrainingViewModel

    private var _binding: FragmentStartTrainingBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val component by lazy {
        (requireActivity().application as TrainingApplication).component
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        component.inject(this)
        _binding = FragmentStartTrainingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this,viewModelFactory)[StartTrainingViewModel::class.java]
        startTrainingAdapter = StartTrainingAdapter()
        binding.rvExercises.adapter = startTrainingAdapter

        viewModel.getExerciseList(args.day).observe(viewLifecycleOwner){
            startTrainingAdapter.submitList(it)
            binding.btnStartTraining.setOnClickListener{ view->
                findNavController().navigate(
                    StartTrainingFragmentDirections.actionStartTrainFragmentToTrainingProcessFragment(
                        it.toTypedArray(),
                        args.day
                    )
                )
            }
        }

        binding.btnBack.setOnClickListener{
            findNavController().popBackStack()
        }

    }
}