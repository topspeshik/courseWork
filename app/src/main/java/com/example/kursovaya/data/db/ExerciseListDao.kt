package com.example.kursovaya.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface ExerciseListDao {

    @Query("SELECT * FROM exercise_items")
    fun getExerciseList(): LiveData<List<ExerciseItemDbModel>>

    @Query("SELECT DISTINCT day_id from exercise_items")
    fun getDaysList(): LiveData<List<Int>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addExerciseItem(exerciseItemDbModel: ExerciseItemDbModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addExerciseItemSync(exerciseItemDbModel: ExerciseItemDbModel)

}