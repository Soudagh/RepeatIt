package com.example.repeatit.data

import android.content.Context
import com.example.repeatit.data.repositories.ItemsRepository
import com.example.repeatit.data.repositories.OfflineItemsRepository
import com.example.repeatit.data.repositories.OfflineThemesRepository
import com.example.repeatit.data.repositories.OfflineUsersRepository
import com.example.repeatit.data.repositories.ThemesRepository
import com.example.repeatit.data.repositories.UsersRepository

interface AppContainer {
    val themesRepository: ThemesRepository
    val itemsRepository : ItemsRepository
    val usersRepository : UsersRepository
}


class AppDataContainer(private val context: Context) : AppContainer {

    override val themesRepository: ThemesRepository by lazy {
        OfflineThemesRepository(AppDatabase.getDatabase(context = context).themeDao())
    }

    override val itemsRepository: ItemsRepository by lazy {
        OfflineItemsRepository(AppDatabase.getDatabase(context = context).itemDao())
    }

    override val usersRepository: UsersRepository by lazy {
        OfflineUsersRepository(AppDatabase.getDatabase(context = context).userDao())
    }
}