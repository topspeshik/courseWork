package com.example.kursovaya.data.db.DayExerciseSettings

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.kursovaya.data.db.AppDatabase
import com.example.kursovaya.domain.db.DayExerciseSettings.DayExerciseSettings
import com.example.kursovaya.domain.db.DayExerciseSettings.DayExerciseSettingsRepository
import com.example.kursovaya.domain.db.DayExerciseSettings.ExerciseWithNetworkTuple
import javax.inject.Inject

class DayExerciseSettingsRepositoryImpl @Inject constructor(
    private val dayExerciseSettingsDao: DayExerciseSettingsDao,
    private val mapper: DayExerciseSettingsMapper
) : DayExerciseSettingsRepository {
//    private val dayExerciseSettingsDao: DayExerciseSettingsDao = AppDatabase.getInstance(application).dayExerciseSettingsDao()
//    private val mapper: DayExerciseSettingsMapper = DayExerciseSettingsMapper()

    override fun getCurrentDay(): LiveData<Int> {
        return Transformations.map(dayExerciseSettingsDao.getCurrentDay()){
            it
        }
    }

    override fun getUniqueDaySettingsList(): LiveData<List<DayExerciseSettings>> {
        return Transformations.map(dayExerciseSettingsDao.getUniqueDaySettingsList()){
            mapper.mapListDayExercisesDbToListEntity(it)
        }
    }

    override fun getExerciseListPerDay(id: Int): LiveData<List<ExerciseWithNetworkTuple>> {
        return Transformations.map(dayExerciseSettingsDao.getExerciseListPerDay(id)){
            mapper.mapListTupleDbToEntity(it)
        }
    }

    override suspend fun addDayExerciseItem(dayExerciseSettings: DayExerciseSettings) {
        dayExerciseSettingsDao.addDayExerciseItem(mapper.mapEntityToDayExerciseSettingsDb(dayExerciseSettings))
    }

    override suspend fun updateActiveToInactive(day_id: Int) {
        dayExerciseSettingsDao.updateActiveToInactive(day_id)
    }

    override suspend fun updateInactiveToActive(day_id: Int) {
        dayExerciseSettingsDao.updateInactiveToActive(day_id)
    }

    override suspend fun deleteDayItem(day_id: Int) {
        dayExerciseSettingsDao.deleteDayItem(day_id)
    }
}