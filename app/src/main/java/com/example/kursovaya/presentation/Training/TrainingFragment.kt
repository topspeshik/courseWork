package com.example.kursovaya.presentation.Training

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.kursovaya.R
import com.example.kursovaya.databinding.FragmentTrainingBinding
import com.example.kursovaya.presentation.Training.TrainingAdapter.TrainingAdapter
import javax.inject.Inject

class TrainingFragment : Fragment() {

    private lateinit var viewModel: TrainingViewModel
    private lateinit var trainingAdapter: TrainingAdapter
    private var currentDay: Int = 0

    private var _binding: FragmentTrainingBinding? = null
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
        // Inflate the layout for this fragment
        _binding = FragmentTrainingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this,viewModelFactory)[TrainingViewModel::class.java]
        trainingAdapter = TrainingAdapter()
        binding.rvDaysList.adapter = trainingAdapter

        viewModel.daysList.observe(viewLifecycleOwner){
            trainingAdapter.submitList(it)
        }

        setupOnExerciseItemClickListener()
        setupCheckBoxListener()
        setupButtonDayClickListener()
        setupSwipeListener(binding.rvDaysList)

        viewModel.getCurrentDay.observe(viewLifecycleOwner){
            currentDay = it ?: 0
        }



    }

    private fun setupOnExerciseItemClickListener(){
        trainingAdapter.onExerciseItemClickListener = {
            findNavController().navigate(
                TrainingFragmentDirections.actionTrainingFragmentToStartTrainFragment(
                    it
                )
            )
        }
    }

    private fun setupCheckBoxListener(){
        trainingAdapter.onActiveCheckBoxClickListener = {
            viewModel.updateActiveToInactive(it)
        }

        trainingAdapter.onInactiveCheckBoxClickListener = {
            viewModel.updateInactiveToActive(it)
        }
    }

    private fun setupButtonDayClickListener(){
        binding.buttonAddDay.setOnClickListener{
            DAY_ID =currentDay+1
            findNavController().navigate(R.id.action_trainingFragment_to_addDayFragment)
        }
    }

    private fun setupSwipeListener(rvDaysList: RecyclerView) {
        val callback = object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val item = trainingAdapter.currentList[viewHolder.adapterPosition]
                viewModel.deleteDayItem(item)
            }
        }
        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(rvDaysList)
    }



    companion object {
        var DAY_ID = 0
    }

}