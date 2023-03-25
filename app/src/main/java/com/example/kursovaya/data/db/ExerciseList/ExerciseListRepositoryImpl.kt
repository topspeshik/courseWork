package com.example.kursovaya.data.db.ExerciseList

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.kursovaya.data.db.AppDatabase
import com.example.kursovaya.domain.db.ExerciseList.ExerciseItem
import com.example.kursovaya.domain.db.ExerciseList.ExerciseListRepository


class ExerciseListRepositoryImpl(
    application: Application
) : ExerciseListRepository  {
    private val exerciseListDao: ExerciseListDao = AppDatabase.getInstance(application).exerciseListDao()
    private val mapper: ExerciseListMapper = ExerciseListMapper()

    override fun getExerciseList(): LiveData<List<ExerciseItem>> {
        return Transformations.map(exerciseListDao.getExerciseList()){
            mapper.mapListExerciseDbToListEntity(it)
        }
    }

    override suspend fun getCurrentId(): Int {
        return exerciseListDao.getCurrentId()
    }

    override suspend fun addExerciseItem(exerciseItem: ExerciseItem) {
        exerciseListDao.addExerciseItem(mapper.mapEntityToExerciseDb(exerciseItem))
    }
}