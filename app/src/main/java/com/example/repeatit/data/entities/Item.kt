package com.example.repeatit.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "items")
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val themeId: Int = 0,
    val firstValue: String,
    val secondValue: String,
    val description: String
)