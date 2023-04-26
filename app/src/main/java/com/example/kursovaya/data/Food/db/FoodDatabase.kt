package com.example.kursovaya.data.Food.db

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kursovaya.data.Food.db.MealsList.MealsListDao
import com.example.kursovaya.data.Food.db.FoodNetwork.FoodNetworkListDao
import com.example.kursovaya.data.Food.db.models.MealsItemDbModel
import com.example.kursovaya.data.Food.db.models.FoodItemDbModel


@Database(
    entities = [
        MealsItemDbModel::class,
        FoodItemDbModel::class
        ],
    version = 1,
    exportSchema = false
)
abstract class FoodDatabase: RoomDatabase() {

    abstract fun breakfastListDao(): MealsListDao
    abstract fun foodNetworkListDao(): FoodNetworkListDao

    companion object {

        private var INSTANCE: FoodDatabase? = null
        private val LOCK = Any()
        private const val DB_NAME = "food.db"

        fun getInstance(application: Application): FoodDatabase {
            INSTANCE?.let {
                return it
            }
            synchronized(LOCK) {
                INSTANCE?.let {
                    return it
                }
                val db = Room.databaseBuilder(
                    application,
                    FoodDatabase::class.java,
                    DB_NAME
                ).build()
                INSTANCE = db
                return db
            }
        }
    }
}