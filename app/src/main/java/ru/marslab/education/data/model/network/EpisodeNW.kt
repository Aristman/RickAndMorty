package ru.marslab.education.data.model.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EpisodeNW(
    @SerialName("air_date")
    val airDate: String,
    @SerialName("characters")
    val characters: List<String>,
    @SerialName("created")
    val created: String,
    @SerialName("episode")
    val episode: String,
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("url")
    val url: String
)
