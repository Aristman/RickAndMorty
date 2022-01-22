package ru.marslab.education.data.model.network

import ru.marslab.education.domain.model.Character

fun CharacterNW.toDomain(): Character =
    Character(
        id = id,
        name = name,
        status = Character.Status.valueOf(status.lowercase()),
        species = species,
        type = type,
        gender = Character.Gender.valueOf(gender.lowercase()),
        origin = Character.CharLocation(origin.name, origin.url),
        location = Character.CharLocation(location.name, location.url),
        image = image,
        episodes = episode,
        url = url,
        created = created
    )
