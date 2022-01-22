package ru.marslab.education.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.marslab.education.domain.interactor.CharactersInteractor
import ru.marslab.education.domain.interactor.CharactersInteractorImpl
import ru.marslab.education.domain.usecase.GetAllCharactersUseCase

@Module
@InstallIn(ViewModelComponent::class)
object InteractorModule {

    @Provides
    fun provideCharacterInteractor(getAllCharactersUseCase: GetAllCharactersUseCase): CharactersInteractor =
        CharactersInteractorImpl(getAllCharactersUseCase)
}
