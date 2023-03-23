package com.example.kursovaya.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kursovaya.data.db.models.DayExerciseSettingsDbModel
import com.example.kursovaya.data.db.models.ExerciseWithNetworkTuple

@Dao
interface DayExerciseSettingsDao {

    @Query("SELECT day_id from day_exercise_settings_items ORDER BY day_id desc LIMIT 1")
    fun getCurrentDay(): LiveData<Int>

    @Query("SELECT * FROM day_exercise_settings_items LEFT JOIN exercise_items ON exercise_items.id = day_exercise_settings_items.exercise_id WHERE day_id = :id")
    fun getExerciseListPerDay(id: Int): LiveData<List<ExerciseWithNetworkTuple>>

    @Query("SELECT DISTINCT day_id from day_exercise_settings_items")
    fun getDaysList(): LiveData<List<Int>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addDayExerciseItem(dayExerciseSettingsDbModel: DayExerciseSettingsDbModel)
}