package com.example.marveltest.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.marveltest.data.remote.domain.Thumbnail
import com.google.gson.annotations.SerializedName

@Entity(tableName = "SERIES_TABLE")
data class SeriesEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val description: String,
    val imageUrl: String,
    val title: String,
)