package com.example.kursovaya.presentation.Training

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.kursovaya.R
import com.example.kursovaya.databinding.FragmentTrainingProcessBinding
import javax.inject.Inject


class TrainingProcessFragment : Fragment() {

    private val args by navArgs<TrainingProcessFragmentArgs>()


    @Inject
    lateinit var viewModelFactory: ViewModelFactory
//    private val viewModelFactory by lazy {
//        TrainingProcessViewModelFactory(requireActivity().application, args.exercises, args.dayId)
//    }
    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[TrainingProcessViewModel::class.java]
    }

    private val component by lazy {
        (requireActivity().application as TrainingApplication).component
    }

    private var _binding: FragmentTrainingProcessBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        component.inject(this)
        //viewModel.initArgs(args.exercises, args.dayId)
        _binding = FragmentTrainingProcessBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initArgs(args.exercises, args.dayId)
        observeViewModel()

        binding.chronometer.base = SystemClock.elapsedRealtime()
        binding.chronometer.start()

        setOnNextButtonListener()
        setOnAddButtonListener()

        binding.btnBack.setOnClickListener{
            findNavController().popBackStack()
        }

    }

    private fun setOnAddButtonListener(){
        binding.ivExerciseAdd.setOnClickListener{
            viewModel.addItem(
                binding.etKg.text.toString(),
                binding.etReps.text.toString()
            )
            it.hideKeyboard()
            binding.etKg.text.clear()
            binding.etReps.text.clear()

        }
    }

    private fun View.hideKeyboard() {
        val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(windowToken, 0)
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
                binding.tvReps.text = it.exercise.reps.toString()
                Glide
                    .with(binding.root.context)
                    .load(it.network.urlgif)
                    .into(binding.ivExercise)
                binding.tvSets.text = "1/${it.exercise.sets}"
                binding.progressBar.progress = 0
        }

        viewModel.shouldAlertShow.observe(viewLifecycleOwner){
            if (it)
                setupAlert()
        }
    }



    private fun setupAlert(){
        binding.chronometer.stop()
        val builder = AlertDialog.Builder(context)
        timerTime = SystemClock.elapsedRealtime() - binding.chronometer.base
        Log.d("checktime", timerTime.toString())
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

    companion object {
        var timerTime : Long = 0
    }
}