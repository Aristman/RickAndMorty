package ru.marslab.education.ui.characters

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.BehaviorSubject
import ru.marslab.education.domain.interactor.CharactersInteractor
import ru.marslab.marslablib.UiState
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val charactersInteractor: CharactersInteractor
) : ViewModel() {
    private val disposableContainer = CompositeDisposable()
    private val charactersList = mutableListOf<CharacterUiState>()

    val charactersUiState: BehaviorSubject<UiState<List<CharacterUiState>, Throwable>> =
        BehaviorSubject.createDefault(UiState.Init)

    fun getAllCharacters(isAdd: Boolean = false) {
        disposableContainer.add(
            charactersInteractor.getAllCharacters()
                .doOnSubscribe { charactersUiState.onNext(UiState.Loading(null)) }
                .map { it.toUi() }
                .toList()
                .subscribe(
                    {
                        if (!isAdd) {
                            charactersList.clear()
                        }
                        charactersList.addAll(it)
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

    fun changeExpanded(item: CharacterUiState) {
        val indexItem = charactersList.indexOf(item)
        charactersUiState.onNext(
            UiState.Success(
                charactersList.apply {
                    add(
                        index = indexItem,
                        element = removeAt(indexItem).copy(isExpand = !item.isExpand)
                    )
                }.toList()
            )
        )
    }
}
