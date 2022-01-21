package ru.marslab.education.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.marslab.education.data.retrofit.CharacterApi
import ru.marslab.education.data.retrofit.EpisodeApi
import ru.marslab.education.data.retrofit.LocationApi
import ru.marslab.education.data.retrofit.RetrofitClient

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideCharacterApi(): CharacterApi =
        RetrofitClient.instance().create(CharacterApi::class.java)

    @Provides
    fun provideLocationApi(): LocationApi =
        RetrofitClient.instance().create(LocationApi::class.java)

    @Provides
    fun provideEpisodeApi(): EpisodeApi =
        RetrofitClient.instance().create(EpisodeApi::class.java)
}
