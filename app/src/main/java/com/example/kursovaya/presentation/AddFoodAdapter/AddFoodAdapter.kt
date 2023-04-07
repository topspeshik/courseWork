package com.example.kursovaya.presentation.AddFoodAdapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.kursovaya.databinding.ItemExerciseAddBinding
import com.example.kursovaya.databinding.ItemFoodAddBinding
import com.example.kursovaya.databinding.ItemFoodBinding
import com.example.kursovaya.domain.Food.db.FoodNetwork.FoodItem

class AddFoodAdapter : ListAdapter<FoodItem, AddFoodViewHolder>(AddFoodDiffCallback) {

    var onFoodItemClickListener: ((FoodItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddFoodViewHolder {
        val binding = ItemFoodAddBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return AddFoodViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AddFoodViewHolder, position: Int) {
        val food = getItem(position)
        with(holder.binding){
            with(food){
                tvName.text = name
                tvKcal.text = kcal.toString() + " ккал"

                ivFoodAdd.setOnClickListener{
                    onFoodItemClickListener?.invoke(this)
                }

            }
        }



    }


}