package ru.marslab.education.data.model.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LocationNW(
    @SerialName("created")
    val created: String,
    @SerialName("dimension")
    val dimension: String,
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("residents")
    val residents: List<String>,
    @SerialName("type")
    val type: String,
    @SerialName("url")
    val url: String
)
