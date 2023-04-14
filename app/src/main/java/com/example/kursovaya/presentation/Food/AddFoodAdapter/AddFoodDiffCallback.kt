package com.example.kursovaya.presentation.Food.AddFoodAdapter

import androidx.recyclerview.widget.DiffUtil
import com.example.kursovaya.domain.Food.db.FoodNetwork.FoodItem

object AddFoodDiffCallback : DiffUtil.ItemCallback<FoodItem>() {

    override fun areItemsTheSame(oldItem: FoodItem, newItem: FoodItem): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: FoodItem, newItem: FoodItem): Boolean {
        return oldItem == newItem
    }
}