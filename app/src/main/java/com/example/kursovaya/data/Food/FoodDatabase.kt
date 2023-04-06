package com.example.kursovaya.data.Food

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kursovaya.data.Food.models.BreakfastItemDbModel
import com.example.kursovaya.data.Training.db.DayExerciseSettings.DayExerciseSettingsDao
import com.example.kursovaya.data.Training.db.ExerciseList.ExerciseListDao
import com.example.kursovaya.data.Training.db.NetworkList.NetworkListDao



@Database(
    entities = [
        BreakfastItemDbModel::class
        ],
    version = 1,
    exportSchema = false
)
abstract class FoodDatabase: RoomDatabase() {



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