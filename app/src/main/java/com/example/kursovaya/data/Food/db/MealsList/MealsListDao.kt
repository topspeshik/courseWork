package com.example.kursovaya.data.Food.db.MealsList

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kursovaya.data.Food.db.models.MealsItemDbModel
import com.example.kursovaya.data.Food.db.models.MealsWithFoodTupleDbModel


@Dao
interface MealsListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addBreakfastItem(MealsItemDbModel: MealsItemDbModel)

    @Query("SELECT * FROM breakfast_items")
    fun getBreakfastList(): LiveData<List<MealsItemDbModel>>

    @Query("SELECT * FROM breakfast_items LEFT JOIN FoodNetwork_items ON breakfast_items.food_name = FoodNetwork_items.name WHERE mealTime = :meal ")
    fun getFullBreakfastFood(meal: String): LiveData<List<MealsWithFoodTupleDbModel>>

    @Query("DELETE FROM breakfast_items WHERE id = :id ")
    fun deleteMealsItem(id: Int)
}