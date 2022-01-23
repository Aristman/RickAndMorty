package ru.marslab.education.ui.characters

import ru.marslab.education.domain.model.Character

fun Character.toUi(): CharacterUiState =
    CharacterUiState(
        id = id,
        name = name,
        type = type,
        gender = gender.name,
        image = image,
        url = url,
        episodes = episodes.map { it.split('/').last().toInt() },
        species = species
    )
