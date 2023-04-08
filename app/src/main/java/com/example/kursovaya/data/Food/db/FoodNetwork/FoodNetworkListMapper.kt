package com.example.kursovaya.data.Food.db.FoodNetwork

import com.example.kursovaya.data.Food.db.models.BreakfastWithFoodTupleDbModel
import com.example.kursovaya.data.Food.db.models.FoodItemDbModel
import com.example.kursovaya.data.Training.db.models.ExerciseWithNetworkTupleDbModel
import com.example.kursovaya.data.Training.db.models.NetworkItemDbModel
import com.example.kursovaya.domain.Food.db.BreakfastList.BreakfastWithFoodTuple
import com.example.kursovaya.domain.Food.db.FoodNetwork.FoodItem
import com.example.kursovaya.domain.Food.network.Food
import com.example.kursovaya.domain.Training.db.DayExerciseSettings.ExerciseWithNetworkTuple
import com.example.kursovaya.domain.Training.db.NetworkList.NetworkItem
import javax.inject.Inject

class FoodNetworkListMapper @Inject constructor(){
    fun mapNetworkDbToEntity(foodItemDbModel: FoodItemDbModel) = FoodItem(
        name = foodItemDbModel.name,
        proteins = foodItemDbModel.proteins,
        carb = foodItemDbModel.carb,
        fats = foodItemDbModel.fats,
        kcal = foodItemDbModel.kcal
    )

    fun mapEntityToNetoworkDb(foodItem: FoodItem) = FoodItemDbModel(
        name = foodItem.name,
        proteins = foodItem.proteins,
        carb = foodItem.carb,
        fats = foodItem.fats,
        kcal = foodItem.kcal
    )

    fun mapListNetworkDbToListEntity(list: List<FoodItemDbModel>) = list.map{
        mapNetworkDbToEntity(it)
    }

}