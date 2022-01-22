package ru.marslab.education.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.marslab.education.data.CharacterRepositoryMockImpl
import ru.marslab.education.domain.repository.CharacterRepository

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideCharacterRepository(): CharacterRepository =
        CharacterRepositoryMockImpl()
}
