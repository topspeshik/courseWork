package com.example.kursovaya.di

import android.app.Application
import com.example.kursovaya.presentation.Food.AddFoodFragment
import com.example.kursovaya.presentation.Food.AddMealFragment
import com.example.kursovaya.presentation.Food.FoodFragment
import com.example.kursovaya.presentation.Training.*
import dagger.BindsInstance
import dagger.Component


@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent {

    fun inject(fragment: StartTrainingFragment)

    fun inject(fragment: AddDayFragment)

    fun inject(fragment: AddExerciseFragment)

    fun inject(fragment: TrainingFragment)

    fun inject(fragment: TrainingProcessFragment)

    fun inject(fragment: AddFoodFragment)

    fun inject(fragment: AddMealFragment)

    fun inject(fragment: FoodFragment)


    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}