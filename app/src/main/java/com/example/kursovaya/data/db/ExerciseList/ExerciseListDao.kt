package com.example.kursovaya.data.db.ExerciseList

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.kursovaya.data.db.models.ExerciseItemDbModel


@Dao
interface ExerciseListDao {

    @Query("SELECT * FROM exercise_items")
    fun getExerciseList(): LiveData<List<ExerciseItemDbModel>>

//    @Query("SELECT * FROM exercise_items LEFT JOIN network_items ON exercise_items.name = network_items.exercise_name WHERE name =:name")
//    fun getExerciseNetworkList(name: String): LiveData<Map<ExerciseItemDbModel, NetworkItemDbModel>>

//    @Query("SELECT * FROM exercise_items")
//    fun getExerciseWithNetworkTuple(): LiveData<List<ExerciseWithNetworkTupleDbModel>>

    @Query("SELECT id from exercise_items ORDER BY id desc LIMIT 1")
    fun getCurrentId(): Int

    @Insert()
    suspend fun addExerciseItem(exerciseItemDbModel: ExerciseItemDbModel)

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun addExerciseItemSync(exerciseItemDbModel: ExerciseItemDbModel)

}