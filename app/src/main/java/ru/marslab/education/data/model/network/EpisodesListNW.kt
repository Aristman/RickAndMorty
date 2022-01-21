package ru.marslab.education.data.model.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EpisodesListNW(
    @SerialName("info")
    val info: ListInfoNW,
    @SerialName("results")
    val results: List<EpisodeNW>
)
