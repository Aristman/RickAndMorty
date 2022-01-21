package ru.marslab.education.data.retrofit

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import ru.marslab.education.data.model.network.EpisodeNW
import ru.marslab.education.data.model.network.EpisodesListNW

interface EpisodeApi {
    @GET("episode")
    fun getAllEpisodes(): Single<EpisodesListNW>

    @GET("episode/{id}")
    fun getEpisodeById(id: Int): Single<EpisodeNW>

    @GET("episode/{ids}")
    fun getEpisodes(ids: List<Int>): Single<List<EpisodeNW>>

    @GET("episode")
    fun getFilterEpisodes(
        @Query("name") name: String?,
        @Query("episode") episode: String?,
    ): Single<EpisodesListNW>
}
