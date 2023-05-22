package com.example.marveltest.data.remote.domain


import com.google.gson.annotations.SerializedName

data class SeriesResultDto(
    @SerializedName("description")
    val description: String?,
    @SerializedName("endYear")
    val endYear: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("modified")
    val modified: String?,
    @SerializedName("previous")
    val previous: Any?,
    @SerializedName("rating")
    val rating: String?,
    @SerializedName("resourceURI")
    val resourceURI: String?,
    @SerializedName("startYear")
    val startYear: Int?,
    @SerializedName("thumbnail")
    val thumbnail: Thumbnail?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("type")
    val type: String?,
)