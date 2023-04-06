package com.example.kursovaya.data.Training.db.ExerciseList

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.kursovaya.domain.Training.db.ExerciseList.ExerciseItem
import com.example.kursovaya.domain.Training.db.ExerciseList.ExerciseListRepository
import javax.inject.Inject


class ExerciseListRepositoryImpl @Inject constructor(
    private val exerciseListDao: ExerciseListDao,
    private val mapper: ExerciseListMapper
) : ExerciseListRepository {
//    private val exerciseListDao: ExerciseListDao = AppDatabase.getInstance(application).exerciseListDao()
//    private val mapper: ExerciseListMapper = ExerciseListMapper()

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