package com.example.kursovaya.data.Food.db

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kursovaya.data.Food.db.BreakfastList.BreakfastListDao
import com.example.kursovaya.data.Food.db.FoodNetwork.FoodNetworkListDao
import com.example.kursovaya.data.Food.db.models.BreakfastItemDbModel
import com.example.kursovaya.data.Food.db.models.FoodItemDbModel


@Database(
    entities = [
        BreakfastItemDbModel::class,
        FoodItemDbModel::class
        ],
    version = 1,
    exportSchema = false
)
abstract class FoodDatabase: RoomDatabase() {

    abstract fun breakfastListDao(): BreakfastListDao
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