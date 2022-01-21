package ru.marslab.education.ui.model

data class CharacterUi(
    val id: Int,
    val name: String,
    val type: String,
    val gender: String,
    val image: String,
    val url: String,
    val episodes: List<Int>,
    val isExpand: Boolean = false
)
