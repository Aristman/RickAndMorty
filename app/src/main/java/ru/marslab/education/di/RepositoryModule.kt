package ru.marslab.education.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.marslab.education.data.CharacterRepositoryImpl
import ru.marslab.education.data.retrofit.CharacterApi
import ru.marslab.education.domain.repository.CharacterRepository

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideCharacterRepository(characterApi: CharacterApi): CharacterRepository =
        CharacterRepositoryImpl(characterApi)
}
