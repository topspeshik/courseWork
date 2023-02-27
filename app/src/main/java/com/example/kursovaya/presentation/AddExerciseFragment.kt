package com.example.kursovaya.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.kursovaya.databinding.FragmentAddExerciseBinding
import com.squareup.picasso.Picasso


class AddExerciseFragment : Fragment() {

    private val args by navArgs<AddExerciseFragmentArgs>()

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

        with(binding){
            tvExercise.text = args.training.name
            Picasso.get().load(args.training.urlimg).into(ivExercise)
        }

    }
}