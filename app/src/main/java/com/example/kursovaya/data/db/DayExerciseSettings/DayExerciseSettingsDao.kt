package com.example.kursovaya.data.db.DayExerciseSettings

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.kursovaya.data.db.models.DayExerciseSettingsDbModel
import com.example.kursovaya.data.db.models.ExerciseWithNetworkTupleDbModel

@Dao
interface DayExerciseSettingsDao {

    @Query("SELECT day_id from day_exercise_settings_items ORDER BY day_id desc LIMIT 1")
    fun getCurrentDay(): LiveData<Int>

//    @Query("SELECT * FROM day_exercise_settings_items")
//    fun getDaySettingsList(): LiveData<List<DayExerciseSettingsDbModel>>

    @Query("SELECT * FROM day_exercise_settings_items GROUP BY day_id")
    fun getUniqueDaySettingsList(): LiveData<List<DayExerciseSettingsDbModel>>

    @Query("SELECT * FROM day_exercise_settings_items LEFT JOIN exercise_items ON exercise_items.id = day_exercise_settings_items.exercise_id WHERE day_id = :id")
    fun getExerciseListPerDay(id: Int): LiveData<List<ExerciseWithNetworkTupleDbModel>>

//    @Query("SELECT DISTINCT day_id from day_exercise_settings_items")
//    fun getDaysList(): LiveData<List<Int>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addDayExerciseItem(dayExerciseSettingsDbModel: DayExerciseSettingsDbModel)

    @Query("UPDATE day_exercise_settings_items SET active=0 WHERE day_id =:day_id")
    suspend fun updateActiveToInactive(day_id: Int)

    @Query("UPDATE day_exercise_settings_items SET active=1 WHERE day_id =:day_id")
    suspend fun updateInactiveToActive(day_id: Int)

    @Query("DELETE FROM day_exercise_settings_items WHERE day_id=:day_id")
    suspend fun deleteDayItem(day_id: Int)


}