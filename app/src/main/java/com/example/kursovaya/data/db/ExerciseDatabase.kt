package com.example.kursovaya.data.db

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ExerciseItemDbModel::class], version = 1, exportSchema = false)
abstract class ExerciseDatabase: RoomDatabase() {

    abstract fun exerciseListDao(): ExerciseListDao

    companion object {

        private var INSTANCE: ExerciseDatabase? = null
        private val LOCK = Any()
        private const val DB_NAME = "exercise_item.db"

        fun getInstance(application: Application): ExerciseDatabase {
            INSTANCE?.let {
                return it
            }
            synchronized(LOCK) {
                INSTANCE?.let {
                    return it
                }
                val db = Room.databaseBuilder(
                    application,
                    ExerciseDatabase::class.java,
                    DB_NAME
                ).build()
                INSTANCE = db
                return db
            }
        }
    }
}