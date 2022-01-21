package ru.marslab.education.domain.repository

import io.reactivex.Observable
import io.reactivex.Single
import ru.marslab.education.domain.model.Character

interface CharacterRepository {
    fun getAllCharacters(): Observable<Character>
    fun getCharacter(id: Int): Single<Character>
    fun getCharacters(ids: List<Int>): Observable<Character>
    fun getFilterCharacters(
        name: String? = null,
        status: Character.Status? = null,
        species: String? = null,
        type: String? = null,
        gender: Character.Gender? = null
    ): Observable<Character>
}
