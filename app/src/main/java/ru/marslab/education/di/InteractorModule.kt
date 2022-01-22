package ru.marslab.education.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import io.reactivex.schedulers.Schedulers
import ru.marslab.education.domain.interactor.CharactersInteractor
import ru.marslab.education.domain.interactor.CharactersInteractorImpl
import ru.marslab.education.domain.repository.CharacterRepository

@Module
@InstallIn(ViewModelComponent::class)
object InteractorModule {

    @Provides
    fun provideCharacterInteractor(
        characterRepository: CharacterRepository,
        schedulers: Schedulers
    ): CharactersInteractor =
        CharactersInteractorImpl(
            characterRepository = characterRepository,
            schedulers = schedulers
        )
}
