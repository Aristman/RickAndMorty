package ru.marslab.education.ui.model

import ru.marslab.education.domain.model.Character

fun Character.toUi(): CharacterUi =
    CharacterUi(
        id = id,
        name = name,
        type = type,
        gender = gender.name,
        image = image,
        url = url,
        episodes = episodes.map { it.split('/').last().toInt() },
        species = species
    )
