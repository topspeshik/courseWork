package com.example.kursovaya.data.db

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kursovaya.data.db.ExerciseList.ExerciseListDao
import com.example.kursovaya.data.db.NetworkList.NetworkListDao
import com.example.kursovaya.data.db.models.DayExerciseSettingsDbModel
import com.example.kursovaya.data.db.models.ExerciseItemDbModel
import com.example.kursovaya.data.db.models.NetworkItemDbModel

@Database(
    entities = [
        ExerciseItemDbModel::class,
        DayExerciseSettingsDbModel::class,
        NetworkItemDbModel::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun exerciseListDao(): ExerciseListDao
    abstract fun networkListDao(): NetworkListDao
    abstract fun dayExerciseSettingsDao(): DayExerciseSettingsDao

    companion object {

        private var INSTANCE: AppDatabase? = null
        private val LOCK = Any()
        private const val DB_NAME = "exercise_item.db"

        fun getInstance(application: Application): AppDatabase {
            INSTANCE?.let {
                return it
            }
            synchronized(LOCK) {
                INSTANCE?.let {
                    return it
                }
                val db = Room.databaseBuilder(
                    application,
                    AppDatabase::class.java,
                    DB_NAME
                ).build()
                INSTANCE = db
                return db
            }
        }
    }
}