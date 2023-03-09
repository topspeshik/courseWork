package com.example.kursovaya.presentation

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.os.SystemClock
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.kursovaya.R
import com.example.kursovaya.databinding.FragmentTrainingProcessBinding



class TrainingProcessFragment : Fragment() {

    private lateinit var viewModel: TrainingProcessViewModel
    private val args by navArgs<TrainingProcessFragmentArgs>()
    private var count = 0

    private var _binding: FragmentTrainingProcessBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTrainingProcessBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvReps.text = args.exercises[count].reps
        binding.tvName.text = args.exercises[count].exercise_name

        Glide
            .with(binding.root.context)
            .load(args.exercises[count].urlgif)
            .into(binding.ivExercise)

        binding.chronometer.base = SystemClock.elapsedRealtime()
        binding.chronometer.start()

        setOnNextButtonListener()


    }

    private fun setOnNextButtonListener(){
        binding.btnNextExercise.setOnClickListener{
            count+=1
            if (count >= args.exercises.size) {
                setupAlert()
            } else {
                binding.tvReps.text = args.exercises[count].reps
                Glide
                    .with(binding.root.context)
                    .load(args.exercises[count].urlgif)
                    .into(binding.ivExercise)
            }
        }
    }

    private fun setupAlert(){
        val builder = AlertDialog.Builder(context)
        with(builder)
        {
            setTitle("Поздравляем")
            setMessage("Тренировка окончена")
            setPositiveButton("Завершить") { _: DialogInterface, _: Int ->
                findNavController().navigate(R.id.trainingFragment)
            }
            show()
        }
    }
}