package ru.marslab.education.data.model.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharactersListNW(
    @SerialName("info")
    val info: ListInfoNW,
    @SerialName("results")
    val results: List<CharacterNW>
)
