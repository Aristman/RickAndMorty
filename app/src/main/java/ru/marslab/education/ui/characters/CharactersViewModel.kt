package ru.marslab.education.ui.characters

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.BehaviorSubject
import ru.marslab.education.domain.interactor.CharactersInteractor
import ru.marslab.education.ui.model.CharacterUi
import ru.marslab.education.ui.model.toUi
import ru.marslab.marslablib.UiState
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val charactersInteractor: CharactersInteractor
) : ViewModel() {
    private val disposableContainer = CompositeDisposable()
    val charactersUiState: BehaviorSubject<UiState<List<CharacterUi>, Throwable>> =
        BehaviorSubject.createDefault(UiState.Init)

    fun getAllCharacters() {
        disposableContainer.add(
            charactersInteractor.getAllCharacters()
                .doOnSubscribe { charactersUiState.onNext(UiState.Loading(null)) }
                .map { it.toUi() }
                .toList()
                .subscribe(
                    {
                        charactersUiState.onNext(UiState.Success(it))
                    },
                    {
                        charactersUiState.onNext(UiState.Error(it))
                    }
                )
        )
    }

    override fun onCleared() {
        disposableContainer.dispose()
        super.onCleared()
    }
}
