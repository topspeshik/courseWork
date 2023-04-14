package com.example.kursovaya.presentation.Food

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.kursovaya.databinding.FragmentAddFoodBinding
import com.example.kursovaya.presentation.Food.AddFoodAdapter.AddFoodAdapter
import com.example.kursovaya.presentation.Training.TrainingApplication
import com.example.kursovaya.presentation.Training.ViewModelFactory
import javax.inject.Inject


class AddFoodFragment : Fragment() {

    private val args by navArgs<AddFoodFragmentArgs>()

    private lateinit var viewModel: AddFoodViewModel

    private lateinit var addFoodAdapter: AddFoodAdapter

    private var _binding: FragmentAddFoodBinding? = null
    private val binding get() = _binding!!

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
        _binding = FragmentAddFoodBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this,viewModelFactory)[AddFoodViewModel::class.java]
        addFoodAdapter = AddFoodAdapter()
        binding.rvFoodList.adapter = addFoodAdapter
        binding.tvName.text = args.name
        setupClickListener()
    }


    private fun setupClickListener(){

        binding.svFood.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let { it ->
                    if (newText.isNotBlank()) {
                        viewModel.getFoodList(it).observe(viewLifecycleOwner) {
                            addFoodAdapter.submitList(it)
                        }
                    }
                }

                return true
            }
        })

        addFoodAdapter.onFoodItemClickListener = {
            findNavController().navigate(
                AddFoodFragmentDirections.actionAddFoodFragmentToAddMealFragment(
                    it,
                    args.name
                )
            )
        }

        binding.btnBack.setOnClickListener{
            findNavController().popBackStack()
        }


    }
}