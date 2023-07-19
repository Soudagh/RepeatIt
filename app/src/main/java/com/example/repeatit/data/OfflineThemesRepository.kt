package com.example.repeatit.data

import kotlinx.coroutines.flow.Flow

class OfflineThemesRepository(private val themeDao: ThemeDao) : ThemesRepository {
    override fun getAllThemesStream(): Flow<List<Theme>> = themeDao.getAllThemes()
    override fun getThemeStream(id: Int): Flow<Theme?> = themeDao.getTheme(id)

    override suspend fun insertTheme(theme: Theme) = themeDao.insert(theme)

    override suspend fun deleteTheme(theme: Theme) = themeDao.delete(theme)

    override suspend fun updateTheme(theme: Theme) = themeDao.update(theme)


}