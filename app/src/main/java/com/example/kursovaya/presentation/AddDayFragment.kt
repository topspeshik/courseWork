package com.example.kursovaya.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import com.example.kursovaya.databinding.FragmentAddDayBinding
import com.example.kursovaya.presentation.AddDayAdapter.AddExerciseAdapter


class AddDayFragment : Fragment() {

    private lateinit var viewModel: AddDayViewModel


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
        val adapter = this.context?.let { AddExerciseAdapter(it) }
        binding.rvExercisesList.adapter = adapter
        binding.svExercises.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                TODO("Not yet implemented")
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {
                    viewModel.searchViewFind(it)
                }
                return true
            }
        })

        viewModel.trainingList.observe(viewLifecycleOwner) {
            adapter?.submitList(it)
        }

    }
}