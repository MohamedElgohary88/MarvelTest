package com.example.marveltest.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SeriesEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val description: String,
    val imageURL: String,
    val title: String
)