package com.example.kursovaya.presentation.Training.StartTrainingAdapter.AddDayAdapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.kursovaya.databinding.ItemExerciseAddBinding
import com.example.kursovaya.domain.Training.db.NetworkList.NetworkItem

class AddExerciseAdapter : ListAdapter<NetworkItem, AddExerciseViewHolder>(AddExerciseDiffCallback) {

    var onExerciseItemClickListener: ((NetworkItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddExerciseViewHolder {
        val binding = ItemExerciseAddBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return AddExerciseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AddExerciseViewHolder, position: Int) {
        val exercise = getItem(position)
        with(holder.binding){
            with(exercise){
                tvName.text = exercise_name
                Glide
                    .with(root.context)
                    .load(urlimg)
                    .into(ivExercise)

                ivExerciseAdd.setOnClickListener{
                    onExerciseItemClickListener?.invoke(this)
                }

            }
        }



    }


}