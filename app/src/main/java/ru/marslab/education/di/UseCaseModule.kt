package ru.marslab.education.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.marslab.education.domain.repository.CharacterRepository
import ru.marslab.education.domain.usecase.GetAllCharactersUseCase

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    fun provideAllCharactersUseCase(characterRepository: CharacterRepository): GetAllCharactersUseCase =
        GetAllCharactersUseCase(characterRepository)
}
