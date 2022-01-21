package ru.marslab.education.data.model.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LocationsListNW(
    @SerialName("info")
    val info: ListInfoNW,
    @SerialName("results")
    val results: List<LocationNW>
)
