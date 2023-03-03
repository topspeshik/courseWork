package com.example.kursovaya.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kursovaya.R
import com.example.kursovaya.data.network.ApiFactory

import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TrainingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_training, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btn = view.findViewById<FloatingActionButton>(R.id.buttonAddDay)
        val apiService = ApiFactory.apiService
        btn.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch {
                Log.d("checkApi", apiService.getTrainingList().toString())
            }
            DAY_ID+=1
            findNavController().navigate(R.id.action_trainingFragment_to_addDayFragment)
        }

    }

    companion object {
        var DAY_ID = 0
    }

}