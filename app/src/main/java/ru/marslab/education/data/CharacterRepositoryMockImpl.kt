package ru.marslab.education.data

import io.reactivex.Observable
import io.reactivex.Single
import ru.marslab.education.domain.model.Character
import ru.marslab.education.domain.repository.CharacterRepository

class CharacterRepositoryMockImpl : CharacterRepository {
    override fun getAllCharacters(): Observable<Character> {
        return Observable.just(Character())
    }

    override fun getCharacter(id: Int): Single<Character> {
        return Single.just(Character())
    }

    override fun getCharacters(ids: List<Int>): Observable<Character> {
        return Observable.just(Character())
    }

    override fun getFilterCharacters(
        name: String?,
        status: Character.Status?,
        species: String?,
        type: String?,
        gender: Character.Gender?
    ): Observable<Character> {
        return Observable.just(Character())
    }
}
