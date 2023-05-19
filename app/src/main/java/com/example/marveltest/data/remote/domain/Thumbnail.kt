package com.example.marveltest.data.remote.domain


import com.google.gson.annotations.SerializedName

data class Thumbnail(
    @SerializedName("extension")
    val extension: String?,
    @SerializedName("path")
    val path: String?
) {
    fun toUrl(): String {
        return "$path.$extension"
    }
}