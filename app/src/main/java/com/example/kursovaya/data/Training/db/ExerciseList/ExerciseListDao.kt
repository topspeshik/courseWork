package com.example.kursovaya.data.Training.db.ExerciseList

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.kursovaya.data.Training.db.models.ExerciseItemDbModel


@Dao
interface ExerciseListDao {

    @Query("SELECT * FROM exercise_items")
    fun getExerciseList(): LiveData<List<ExerciseItemDbModel>>

    @Query("SELECT id from exercise_items ORDER BY id desc LIMIT 1")
    fun getCurrentId(): Int

    @Insert()
    suspend fun addExerciseItem(exerciseItemDbModel: ExerciseItemDbModel)

}