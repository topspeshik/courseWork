package com.example.kursovaya.data.Food.BreakfastList

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.kursovaya.domain.Food.db.BreakfastList.BreakfastItem
import com.example.kursovaya.domain.Food.db.BreakfastList.BreakfastListRepository
import com.example.kursovaya.domain.Training.db.ExerciseList.ExerciseItem
import com.example.kursovaya.domain.Training.db.ExerciseList.ExerciseListRepository
import javax.inject.Inject


class BreakfastListRepositoryImpl @Inject constructor(
    private val breakfastListDao: BreakfastListDao,
    private val mapper: BreakfastListMapper
) : BreakfastListRepository {

    override fun getBreakfastList(): LiveData<List<BreakfastItem>> {
        return Transformations.map(breakfastListDao.getBreakfastList()){
            mapper.mapBreakfastListDbToListEntity(it)
        }
    }



    override suspend fun addBreakfastItem(breakfastItem: BreakfastItem) {
        breakfastListDao.addBreakfastItem(mapper.mapEntityToBreakfastDb(breakfastItem))
    }
}