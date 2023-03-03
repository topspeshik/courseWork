package com.example.kursovaya.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy


@Dao
interface ExerciseListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addExerciseItem(exerciseItemDbModel: ExerciseItemDbModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addExerciseItemSync(exerciseItemDbModel: ExerciseItemDbModel)

}