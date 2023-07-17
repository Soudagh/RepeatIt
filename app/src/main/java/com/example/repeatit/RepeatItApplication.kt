package com.example.repeatit

import android.app.Application
import com.example.repeatit.data.AppContainer
import com.example.repeatit.data.AppDataContainer

class RepeatItApplication : Application() {

    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}