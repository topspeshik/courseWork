package com.example.kursovaya.di

import android.app.Application
import androidx.navigation.fragment.navArgs
import com.example.kursovaya.data.db.AppDatabase
import com.example.kursovaya.data.db.DayExerciseSettings.DayExerciseSettingsDao
import com.example.kursovaya.data.db.DayExerciseSettings.DayExerciseSettingsRepositoryImpl
import com.example.kursovaya.data.db.ExerciseList.ExerciseListDao
import com.example.kursovaya.data.db.ExerciseList.ExerciseListRepositoryImpl
import com.example.kursovaya.data.db.NetworkList.NetworkListDao
import com.example.kursovaya.data.db.NetworkList.NetworkRepositoryImpl
import com.example.kursovaya.data.network.ApiFactory
import com.example.kursovaya.data.network.ApiService
import com.example.kursovaya.data.network.TrainingRepositoryImpl
import com.example.kursovaya.domain.db.DayExerciseSettings.DayExerciseSettingsRepository
import com.example.kursovaya.domain.db.DayExerciseSettings.ExerciseWithNetworkTuple
import com.example.kursovaya.domain.db.ExerciseList.ExerciseItem
import com.example.kursovaya.domain.db.ExerciseList.ExerciseListRepository
import com.example.kursovaya.domain.db.NetworkList.NetworkItem
import com.example.kursovaya.domain.db.NetworkList.NetworkRepository
import com.example.kursovaya.domain.network.TrainingRepository
import com.example.kursovaya.presentation.TrainingProcessFragmentArgs
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