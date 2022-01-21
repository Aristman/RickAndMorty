package ru.marslab.education.ui.characters

import androidx.fragment.app.viewModels
import ru.marslab.education.databinding.FragmentCharactersBinding
import ru.marslab.marslablib.FragmentBindWithVM

class CharactersFragment :
    FragmentBindWithVM<CharactersViewModel, FragmentCharactersBinding>(FragmentCharactersBinding::inflate) {

    override val fragmentViewModel: CharactersViewModel by viewModels()
}
