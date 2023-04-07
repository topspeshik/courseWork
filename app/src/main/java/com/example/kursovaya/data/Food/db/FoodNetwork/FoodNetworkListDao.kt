package com.example.kursovaya.data.Food.db.FoodNetwork

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kursovaya.data.Food.db.models.FoodItemDbModel

@Dao
interface FoodNetworkListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNetworkItem(foodItemDbModel: FoodItemDbModel)

    @Query("SELECT * FROM FoodNetwork_items WHERE name LIKE :sym")
    fun searchName(sym: String): LiveData<List<FoodItemDbModel>>
}