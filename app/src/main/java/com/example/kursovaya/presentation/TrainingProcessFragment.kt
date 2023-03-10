package com.example.kursovaya.presentation

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.os.SystemClock
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.kursovaya.R
import com.example.kursovaya.databinding.FragmentTrainingProcessBinding



class TrainingProcessFragment : Fragment() {

    private val args by navArgs<TrainingProcessFragmentArgs>()
    private val viewModelFactory by lazy {
        TrainingProcessViewModelFactory(requireActivity().application, args.exercises)
    }
    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[TrainingProcessViewModel::class.java]
    }

    private var count = 0
    private var countSets = 1

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

        observeViewModel()
//        binding.tvReps.text = args.exercises[count].reps.toString()
//        binding.tvName.text = args.exercises[count].exercise_name
//        binding.tvSets.text = "1/${args.exercises[count].sets}"
//        Glide
//            .with(binding.root.context)
//            .load(args.exercises[count].urlgif)
//            .into(binding.ivExercise)

        binding.chronometer.base = SystemClock.elapsedRealtime()
        binding.chronometer.start()

        setOnNextButtonListener()
        setOnAddButtonListener()


    }

    private fun setOnAddButtonListener(){
        binding.ivExerciseAdd.setOnClickListener{
            viewModel.addItem(
                binding.etKg.text.toString(),
                binding.etReps.text.toString()

            )
//            countSets+=1
//            binding.tvSets.text = "$countSets/${args.exercises[count].sets}"
//            binding.progressBar.progress = ((countSets/args.exercises[count].sets.toFloat()) * 100).toInt()

        }
    }

    private fun setOnNextButtonListener(){
        binding.btnNextExercise.setOnClickListener {
            viewModel.newPage()
        }

    }

    private fun observeViewModel(){

        viewModel.errorInputCount.observe(viewLifecycleOwner){
            if (it)
                Toast.makeText(context, "Заполните поля", Toast.LENGTH_SHORT).show()
        }

        viewModel.progress.observe(viewLifecycleOwner){
            binding.progressBar.progress = it
        }

        viewModel.progressText.observe(viewLifecycleOwner){
            binding.tvSets.text = it
        }

        viewModel.exercise.observe(viewLifecycleOwner){
                binding.tvReps.text = it.reps.toString()
                Glide
                    .with(binding.root.context)
                    .load(it.urlgif)
                    .into(binding.ivExercise)
                binding.tvSets.text = "1/${it.sets}"
                binding.progressBar.progress = 0
        }

        viewModel.shouldAlertShow.observe(viewLifecycleOwner){
            if (it)
                setupAlert()
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