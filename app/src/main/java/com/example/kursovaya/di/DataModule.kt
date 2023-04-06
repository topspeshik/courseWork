package com.example.kursovaya.di

import android.app.Application
import com.example.kursovaya.data.Training.db.AppDatabase
import com.example.kursovaya.data.Training.db.DayExerciseSettings.DayExerciseSettingsDao
import com.example.kursovaya.data.Training.db.DayExerciseSettings.DayExerciseSettingsRepositoryImpl
import com.example.kursovaya.data.Training.db.ExerciseList.ExerciseListDao
import com.example.kursovaya.data.Training.db.ExerciseList.ExerciseListRepositoryImpl
import com.example.kursovaya.data.Training.db.NetworkList.NetworkListDao
import com.example.kursovaya.data.Training.db.NetworkList.NetworkRepositoryImpl
import com.example.kursovaya.data.Training.network.ApiFactory
import com.example.kursovaya.data.Training.network.ApiService
import com.example.kursovaya.data.Training.network.TrainingRepositoryImpl
import com.example.kursovaya.domain.Training.db.DayExerciseSettings.DayExerciseSettingsRepository
import com.example.kursovaya.domain.Training.db.DayExerciseSettings.ExerciseWithNetworkTuple
import com.example.kursovaya.domain.Training.db.ExerciseList.ExerciseListRepository
import com.example.kursovaya.domain.Training.db.NetworkList.NetworkRepository
import com.example.kursovaya.domain.Training.network.TrainingRepository

import dagger.Binds
import dagger.Module
import dagger.Provides


@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindNetworkRepository(impl: NetworkRepositoryImpl): NetworkRepository

    @ApplicationScope
    @Binds
    fun bindTrainingRepository(impl: TrainingRepositoryImpl): TrainingRepository

    @ApplicationScope
    @Binds
    fun bindExerciseListRepository(impl: ExerciseListRepositoryImpl): ExerciseListRepository

    @ApplicationScope
    @Binds
    fun bindDayExerciseSettingsRepository(impl: DayExerciseSettingsRepositoryImpl): DayExerciseSettingsRepository


    companion object {
        @ApplicationScope
        @Provides
        fun provideNetworkDao(
            application: Application
        ): NetworkListDao {
            return AppDatabase.getInstance(application).networkListDao()
        }

        @ApplicationScope
        @Provides
        fun provideExerciseListDao(
            application: Application
        ): ExerciseListDao {
            return AppDatabase.getInstance(application).exerciseListDao()
        }

        @ApplicationScope
        @Provides
        fun provideDayExerciseSettingsDao(
            application: Application
        ): DayExerciseSettingsDao {
            return AppDatabase.getInstance(application).dayExerciseSettingsDao()
        }

        @Provides
        @ApplicationScope
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }

        @Provides
        @ApplicationScope
        fun provideApiFactory(): ApiFactory {
            return ApiFactory
        }


        @Provides
        @ApplicationScope
        fun provideDayId(day_id: Int): Int {
            return day_id
        }

        @Provides
        @ApplicationScope
        fun provideTuple( exerciseWithNetworkTuple:Array<ExerciseWithNetworkTuple> ): Array<ExerciseWithNetworkTuple> {
            return exerciseWithNetworkTuple
        }


    }
}