package com.example.kursovaya.presentation

import android.app.Application
import com.example.kursovaya.di.DaggerApplicationComponent

class TrainingApplication : Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}