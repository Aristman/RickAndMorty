package ru.marslab.education.domain.usecase

import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.Observable
import ru.marslab.education.domain.model.Character
import ru.marslab.education.domain.repository.CharacterRepository
import javax.inject.Inject

@AndroidEntryPoint
class GetAllCharactersUseCase @Inject constructor(
    private val characterRepository: CharacterRepository
) {
    operator fun invoke(): Observable<Character> =
        characterRepository.getAllCharacters()
}
