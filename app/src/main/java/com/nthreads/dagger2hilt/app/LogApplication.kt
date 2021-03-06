package com.nthreads.dagger2hilt.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


//@HiltAndroidApp
open class LogApplication : Application() {

    lateinit var serviceLocator: ServiceLocator

    override fun onCreate() {
        super.onCreate()
        serviceLocator = ServiceLocator(applicationContext)
    }
}