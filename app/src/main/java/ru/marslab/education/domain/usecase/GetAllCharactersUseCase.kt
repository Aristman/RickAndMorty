package ru.marslab.education.domain.usecase

import io.reactivex.Observable
import ru.marslab.education.domain.model.Character
import ru.marslab.education.domain.repository.CharacterRepository

class GetAllCharactersUseCase(
    private val characterRepository: CharacterRepository
) {
    operator fun invoke(): Observable<Character> =
        characterRepository.getAllCharacters()
}
