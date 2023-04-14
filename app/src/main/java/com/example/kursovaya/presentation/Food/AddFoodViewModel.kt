package com.example.kursovaya.presentation.Food

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kursovaya.domain.Food.db.FoodNetwork.FoodItem
import com.example.kursovaya.domain.Food.db.FoodNetwork.addFoodNetworkItemUseCase
import com.example.kursovaya.domain.Food.db.FoodNetwork.searchNameUseCase
import com.example.kursovaya.domain.Food.network.getFoodListUseCase
import com.example.kursovaya.domain.Food.network.getUpdateFoodInfoUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class AddFoodViewModel @Inject constructor(
    private val getFoodListUseCase: getFoodListUseCase,
    private val getUpdateFoodInfoUseCase: getUpdateFoodInfoUseCase,
    private val addFoodNetworkItemUseCase: addFoodNetworkItemUseCase,
    private val searchNameUseCase : searchNameUseCase
): ViewModel()  {

    private var lastUpdate: String = ""

    fun getFoodList(sym: String): LiveData<List<FoodItem>> {
        loadData()
        return searchNameUseCase("%$sym%")

    }

    private fun loadData(){
        viewModelScope.launch {
            val update = getUpdateFoodInfoUseCase()
            if (update.date.toString() != lastUpdate){
                val fList = getFoodListUseCase()
                for (food in fList){
                    addFoodNetworkItemUseCase(
                        FoodItem(
                            food.name!!,
                            food.proteins!!,
                            food.fats!!,
                            food.carb!!,
                            food.kcal!!
                        )
                    )
                }
            }
            lastUpdate = update.date.toString()
        }

    }
}