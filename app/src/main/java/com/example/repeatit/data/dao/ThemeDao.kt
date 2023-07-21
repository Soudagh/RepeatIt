package com.example.repeatit.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.repeatit.data.entities.Theme
import kotlinx.coroutines.flow.Flow

@Dao
interface ThemeDao {

    @Insert
    suspend fun insert(theme: Theme)

    @Update
    suspend fun update(theme: Theme)

    @Delete
    suspend fun delete(theme: Theme)

    @Query("SELECT * from themes WHERE id = :id")
    fun getTheme(id: Int): Flow<Theme>

    @Query("SELECT * from themes")
    fun getAllThemes(): Flow<List<Theme>>
}