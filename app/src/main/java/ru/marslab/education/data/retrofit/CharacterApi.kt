package ru.marslab.education.data.retrofit

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import ru.marslab.education.data.model.network.CharacterNW
import ru.marslab.education.data.model.network.CharactersListNW

interface CharacterApi {

    @GET("character")
    fun getAllCharacters(): Single<CharactersListNW>

    @GET("character/{id}")
    fun getCharacterById(id: Int): Single<CharacterNW>

    @GET("character/{ids}")
    fun getCharacters(ids: List<Int>): Single<List<CharacterNW>>

    @GET("character")
    fun getFilterCharacters(
        @Query("name") name: String?,
        @Query("status") status: String?,
        @Query("species") species: String?,
        @Query("type") type: String?,
        @Query("gender") gender: String?,
    ): Single<CharactersListNW>
}
