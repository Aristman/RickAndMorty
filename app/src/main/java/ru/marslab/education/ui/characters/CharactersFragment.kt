package ru.marslab.education.ui.characters

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import ru.marslab.education.databinding.FragmentCharactersBinding
import ru.marslab.education.ui.model.CharacterUi
import ru.marslab.marslablib.FragmentBindWithVM
import ru.marslab.marslablib.UiState

@AndroidEntryPoint
class CharactersFragment :
    FragmentBindWithVM<CharactersViewModel, FragmentCharactersBinding>(FragmentCharactersBinding::inflate) {

    override val fragmentViewModel: CharactersViewModel by viewModels()

    private val disposableContainer = CompositeDisposable()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservable()
    }

    private fun initObservable() {
        disposableContainer.add(
            fragmentViewModel.charactersUiState
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        renderData(it)
                    },
                    {
                        // TODO Обработка ошибки потока.
                    }
                )
        )
    }

    private fun renderData(data: UiState<List<CharacterUi>, Throwable>) {
        when (data) {
            UiState.Init -> {}
            is UiState.Success -> {
                updateFragment(data.data)
            }
            is UiState.Error -> {}
            is UiState.Loading -> {}
        }
    }

    private fun updateFragment(data: List<CharacterUi>) {
        // TODO("Not yet implemented")
    }
}
