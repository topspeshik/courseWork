package com.example.kursovaya.presentation

import android.app.Application

class TrainingApplication : Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}