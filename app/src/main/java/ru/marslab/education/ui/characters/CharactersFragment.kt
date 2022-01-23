package ru.marslab.education.ui.characters

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import ru.marslab.education.databinding.FragmentCharactersBinding
import ru.marslab.education.ui.characters.adapter.CharacterListAdapter
import ru.marslab.marslablib.FragmentBindWithVM
import ru.marslab.marslablib.UiState

@AndroidEntryPoint
class CharactersFragment :
    FragmentBindWithVM<CharactersViewModel, FragmentCharactersBinding>(FragmentCharactersBinding::inflate) {

    override val fragmentViewModel: CharactersViewModel by viewModels()

    private val disposableContainer = CompositeDisposable()
    private val characterListAdapter by lazy {
        CharacterListAdapter(
            onCardClick = { fragmentViewModel.changeExpanded(it) },
            onCardLongClick = {},
            onDetailClick = {}
        )
    }

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
                        showError(it)
                    }
                )
        )
    }

    private fun renderData(data: UiState<List<CharacterUiState>, Throwable>) {
        when (data) {
            UiState.Init -> {
                initView()
            }
            is UiState.Success -> {
                showCharactersList(data.data)
            }
            is UiState.Error -> {
                showError(data.error)
            }
            is UiState.Loading -> {
                showLoading()
            }
        }
    }

    private fun showError(error: Throwable) {
        Toast.makeText(requireContext(), error.message, Toast.LENGTH_SHORT).show()
    }

    private fun initView() {
        binding.run {
            loadingIndicator.hide()
            charactersList.visibility = View.GONE
        }
        binding.charactersList.run {
            adapter = characterListAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            fragmentViewModel.getAllCharacters()
        }
    }

    private fun showLoading() {
        binding.run {
            loadingIndicator.show()
            charactersList.visibility = View.GONE
        }
    }

    private fun showCharactersList(data: List<CharacterUiState>) {
        binding.run {
            loadingIndicator.hide()
            charactersList.visibility = View.VISIBLE
        }
        characterListAdapter.submitList(data)
    }

    override fun onDestroyView() {
        disposableContainer.dispose()
        super.onDestroyView()
    }
}
