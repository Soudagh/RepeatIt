package com.example.repeatit.data.repositories

import com.example.repeatit.data.entities.Theme
import kotlinx.coroutines.flow.Flow

interface ThemesRepository {

    fun getAllThemesStream(): Flow<List<Theme>>

    fun getThemeStream(id: Int): Flow<Theme?>

    suspend fun insertTheme(theme: Theme)

    suspend fun deleteTheme(theme: Theme)

    suspend fun updateTheme(theme: Theme)
}