package ru.marslab.education.data

import io.reactivex.Observable
import io.reactivex.Single
import ru.marslab.education.domain.model.Character
import ru.marslab.education.domain.repository.CharacterRepository
import java.util.concurrent.TimeUnit

class CharacterRepositoryMockImpl : CharacterRepository {
    override fun getAllCharacters(): Observable<Character> {
        return Observable.intervalRange(1, 10, 0, 500L, TimeUnit.MILLISECONDS)
            .map {
                Character(
                    name = "Rick $it",
                    image = "https://phonoteka.org/uploads/posts/2021-07/1625617138_11-phonoteka-org-p-rik-i-morti-art-krasivo-11.jpg"
                )
            }
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
