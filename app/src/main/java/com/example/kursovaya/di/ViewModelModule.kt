package com.example.kursovaya.di

import androidx.lifecycle.ViewModel
import com.example.kursovaya.presentation.Food.AddFoodViewModel
import com.example.kursovaya.presentation.Food.AddMealViewModel
import com.example.kursovaya.presentation.Food.FoodViewModel
import com.example.kursovaya.presentation.Training.*
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(AddDayViewModel::class)
    fun bindMainViewModel(viewModel: AddDayViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AddExerciseViewModel::class)
    fun bindAddExerciseViewModel(viewModel: AddExerciseViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(StartTrainingViewModel::class)
    fun bindStartTrainingViewModel(viewModel: StartTrainingViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TrainingProcessViewModel::class)
    fun bindTrainingProcessViewModel(viewModel: TrainingProcessViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TrainingViewModel::class)
    fun bindTrainingViewModel(viewModel: TrainingViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AddFoodViewModel::class)
    fun bindAddFoodViewModel(viewModel: AddFoodViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AddMealViewModel::class)
    fun bindAddMealViewModel(viewModel: AddMealViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FoodViewModel::class)
    fun bindFoodViewModel(viewModel: FoodViewModel): ViewModel

}