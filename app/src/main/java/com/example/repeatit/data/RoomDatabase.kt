package com.example.repeatit.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.repeatit.data.dao.ItemDao
import com.example.repeatit.data.dao.ThemeDao
import com.example.repeatit.data.dao.UserDao
import com.example.repeatit.data.entities.Theme

@Database(entities = [Theme::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun themeDao() : ThemeDao
    abstract fun itemDao() : ItemDao
    abstract fun userDao() : UserDao

    companion object {
        @Volatile
        private var Instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, AppDatabase::class.java, "app_database")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}