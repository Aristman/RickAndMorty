package ru.marslab.education.domain.interactor

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import ru.marslab.education.domain.model.Character
import ru.marslab.education.domain.usecase.GetAllCharactersUseCase

class CharactersInteractorImpl(
    private val getAllCharactersUseCase: GetAllCharactersUseCase
) : CharactersInteractor {

    override fun getAllCharacters(): Observable<Character> =
        getAllCharactersUseCase().subscribeOn(Schedulers.io())
}
