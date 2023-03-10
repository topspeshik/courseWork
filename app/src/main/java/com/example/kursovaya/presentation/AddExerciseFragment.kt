package com.example.kursovaya.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
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
        // Inflate the layout for this fragment
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
//            Picasso.get().load(args.training.urlimg).into(ivExercise)

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
            }
        }

        viewModel.errorInputCount.observe(viewLifecycleOwner){
            if(it){
                Toast.makeText(context,"Введите значения!", Toast.LENGTH_SHORT).show()
            }
        }

    }
}