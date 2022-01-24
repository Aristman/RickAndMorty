package ru.marslab.education.data

import io.reactivex.Observable
import io.reactivex.Single
import ru.marslab.education.data.model.network.toDomain
import ru.marslab.education.data.retrofit.CharacterApi
import ru.marslab.education.domain.model.Character
import ru.marslab.education.domain.repository.CharacterRepository

class CharacterRepositoryImpl(private val characterApi: CharacterApi) : CharacterRepository {
    override fun getAllCharacters(): Observable<Character> =
        characterApi.getAllCharacters()
            .flatMapObservable { response ->
                Observable.fromIterable(
                    response.results.map { it.toDomain() }
                )
            }

    override fun getCharacter(id: Int): Single<Character> =
        characterApi.getCharacterById(id)
            .map { it.toDomain() }

    override fun getCharacters(ids: List<Int>): Observable<Character> =
        characterApi.getCharacters(ids)
            .flatMapObservable { response ->
                Observable
                    .fromIterable(
                        response.map { it.toDomain() }
                    )
            }

    override fun getFilterCharacters(
        name: String?,
        status: Character.Status?,
        species: String?,
        type: String?,
        gender: Character.Gender?
    ): Observable<Character> =
        characterApi.getFilterCharacters(name, status?.name, species, type, gender?.name)
            .flatMapObservable { response ->
                Observable.fromIterable(
                    response.results.map { it.toDomain() }
                )
            }
}
