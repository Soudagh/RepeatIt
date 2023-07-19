package com.example.repeatit.data

import android.content.Context

interface AppContainer {
    val themesRepository: ThemesRepository
}


class AppDataContainer(private val context: Context) : AppContainer {

    override val themesRepository: ThemesRepository by lazy {
        OfflineThemesRepository(AppDatabase.getDatabase(context = context).themeDao())
    }
}