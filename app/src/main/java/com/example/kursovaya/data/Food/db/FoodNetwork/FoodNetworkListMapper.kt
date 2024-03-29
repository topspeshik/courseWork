package com.example.kursovaya.data.Food.db.FoodNetwork

import com.example.kursovaya.data.Food.db.models.FoodItemDbModel
import com.example.kursovaya.domain.Food.db.FoodNetwork.FoodItem
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