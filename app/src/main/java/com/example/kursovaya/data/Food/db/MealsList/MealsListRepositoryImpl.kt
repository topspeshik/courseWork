package com.example.kursovaya.data.Food.db.MealsList

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.kursovaya.domain.Food.db.MealsList.MealsItem
import com.example.kursovaya.domain.Food.db.MealsList.MealsListRepository
import com.example.kursovaya.domain.Food.db.MealsList.MealsWithFoodTuple
import javax.inject.Inject


class MealsListRepositoryImpl @Inject constructor(
    private val mealsListDao: MealsListDao,
    private val mapper: MealsListMapper
) : MealsListRepository {

    override fun getBreakfastList(): LiveData<List<MealsItem>> {
        return Transformations.map(mealsListDao.getBreakfastList()){
            mapper.mapBreakfastListDbToListEntity(it)
        }
    }


    override suspend fun deleteMealsItem(id: Int) {
        mealsListDao.deleteMealsItem(id)
    }

    override suspend fun addBreakfastItem(mealsItem: MealsItem) {
        mealsListDao.addBreakfastItem(mapper.mapEntityToBreakfastDb(mealsItem))
    }

    override fun getFullBreakfastFood(meal: String): LiveData<List<MealsWithFoodTuple>> {
        return Transformations.map(mealsListDao.getFullBreakfastFood(meal)){
            mapper.mapListTupleDbToEntity(it)
        }
    }
}