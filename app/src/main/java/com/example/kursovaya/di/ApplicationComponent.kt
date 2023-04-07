package com.example.kursovaya.di

import android.app.Application
import com.example.kursovaya.presentation.AddFoodFragment
import com.example.kursovaya.presentation.Training.StartTrainingAdapter.*
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

    fun inject(fragment: StartTrainFragment)

    fun inject(fragment: AddDayFragment)

    fun inject(fragment: AddExerciseFragment)

    fun inject(fragment: TrainingFragment)

    fun inject(fragment: TrainingProcessFragment)

    fun inject(fragment: AddFoodFragment)


    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}