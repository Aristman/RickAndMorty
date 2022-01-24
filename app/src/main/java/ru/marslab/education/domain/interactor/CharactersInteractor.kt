package ru.marslab.education.domain.interactor

import io.reactivex.Observable
import ru.marslab.education.domain.model.Character

interface CharactersInteractor {
    fun getAllCharacters(): Observable<Character>
}
