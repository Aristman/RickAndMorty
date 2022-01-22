package ru.marslab.education.domain.interactor

import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import ru.marslab.education.domain.model.Character
import ru.marslab.education.domain.repository.CharacterRepository
import javax.inject.Inject

@AndroidEntryPoint
class CharactersInteractorImpl @Inject constructor(
    private val characterRepository: CharacterRepository,
    private val schedulers: Schedulers
) : CharactersInteractor {
    override fun getAllCharacters(): Observable<Character> =
        characterRepository.getAllCharacters()
}
