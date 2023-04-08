package com.example.kursovaya.data.Food.db.BreakfastList

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kursovaya.data.Food.db.models.BreakfastItemDbModel
import com.example.kursovaya.data.Food.db.models.BreakfastWithFoodTupleDbModel
import com.example.kursovaya.data.Training.db.models.ExerciseWithNetworkTupleDbModel


@Dao
interface BreakfastListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addBreakfastItem(BreakfastItemDbModel: BreakfastItemDbModel)

    @Query("SELECT * FROM breakfast_items")
    fun getBreakfastList(): LiveData<List<BreakfastItemDbModel>>

    @Query("SELECT * FROM breakfast_items LEFT JOIN FoodNetwork_items ON breakfast_items.food_name = FoodNetwork_items.name")
    fun getFullBreakfastFood(): LiveData<List<BreakfastWithFoodTupleDbModel>>
}